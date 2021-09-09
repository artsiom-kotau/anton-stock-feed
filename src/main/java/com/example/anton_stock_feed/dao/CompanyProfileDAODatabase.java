package com.example.anton_stock_feed.dao;

import com.example.anton_stock_feed.exceptions.DAOException;
import com.example.anton_stock_feed.entity.CompanyEntity;

import java.sql.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

public class CompanyProfileDAODatabase implements CompanyProfileDAO {
    private volatile static CompanyProfileDAODatabase companyProfileDAODatabase;

    private CompanyProfileDAODatabase() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new DAOException(e);
        }
    }

    public static CompanyProfileDAODatabase getInstance() {
        if (companyProfileDAODatabase == null) {
            synchronized (CompanyProfileDAODatabase.class) {
                if (companyProfileDAODatabase == null) {
                    companyProfileDAODatabase = new CompanyProfileDAODatabase();
                }
            }
        }
        return companyProfileDAODatabase;
    }

    @Override
    public Optional<CompanyEntity> getInfo(String companySymbol) {
        CompanyEntity companyEntity = null;

        try (Connection dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/stockfeed",
                "postgres",
                "PedbbRw4");
             PreparedStatement preparedStatement = dbConnection.prepareStatement("SELECT * FROM company_profile WHERE symbol = ?")) {

            preparedStatement.setString(1, companySymbol);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String currency = rs.getString("currency");
                String description = rs.getString("description");
                String displaysymbol = rs.getString("displaysymbol");
                String symbol = rs.getString("symbol");
                String figi = rs.getString("figi");
                String mic = rs.getString("mic");
                String type = rs.getString("type");

                companyEntity = new CompanyEntity(currency, description, displaysymbol, figi, mic, symbol, type);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return Optional.ofNullable(companyEntity);
    }

    @Override
    public void writeData(Iterable<CompanyEntity> apiCompanies) {
        Collection<String> companySymbolsDatabase;
        Collection<CompanyEntity> insertCompanies = new HashSet<CompanyEntity>();
        Collection<String> insertUpdateCompanies = new HashSet<String>();
        Collection<CompanyEntity> updateCompanies = new HashSet<CompanyEntity>();

        try (Connection dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/stockfeed",
                "postgres",
                "PedbbRw4")) {
            dbConnection.setAutoCommit(false);

            try {
                companySymbolsDatabase = checkAvailability(dbConnection);
                for (CompanyEntity companyEntity : apiCompanies) {
                    String companySymbol = companyEntity.getSymbol();
                    if (companySymbolsDatabase.contains(companySymbol)) {
                        updateCompanies.add(companyEntity);
                    } else {
                        insertCompanies.add(companyEntity);
                    }
                }

                for (CompanyEntity companyEntity : insertCompanies) {
                    insertUpdateCompanies.add(companyEntity.getSymbol());
                }
                for (CompanyEntity companyEntity : updateCompanies) {
                    insertUpdateCompanies.add(companyEntity.getSymbol());
                }
                companySymbolsDatabase.removeAll(insertUpdateCompanies);

                if (updateCompanies.size() > 0) {
                    updateCompanies(updateCompanies, dbConnection);
                }
                if (insertCompanies.size() > 0) {
                    insertCompanies(insertCompanies, dbConnection);
                }
                if (companySymbolsDatabase.size() > 0) {
                    deleteCompanies(companySymbolsDatabase, dbConnection);
                }
                dbConnection.commit();
            } catch (SQLException e) {
                dbConnection.rollback();
                throw new DAOException(e);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    private Collection checkAvailability(Connection dbConnection) {
        Collection<String> companySymbolsDatabase = new HashSet<String>();
        try (PreparedStatement preparedStatement = dbConnection.prepareStatement("SELECT symbol FROM company_profile")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                companySymbolsDatabase.add(rs.getString("symbol"));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return companySymbolsDatabase;
    }

    private void updateCompanies(Iterable<CompanyEntity> updateList, Connection dbConnection) {
        try (PreparedStatement preparedStatement = dbConnection.prepareStatement(
                "UPDATE company_profile SET currency=?, description=?, displaysymbol=?, figi=?, mic=?, symbol=?, type=? WHERE symbol=?")) {
            for (CompanyEntity companyEntity : updateList) {
                preparedStatement.setString(1, companyEntity.getCurrency());
                preparedStatement.setString(2, companyEntity.getDescription());
                preparedStatement.setString(3, companyEntity.getDisplaySymbol());
                preparedStatement.setString(4, companyEntity.getFigi());
                preparedStatement.setString(5, companyEntity.getMic());
                preparedStatement.setString(6, companyEntity.getSymbol());
                preparedStatement.setString(7, companyEntity.getType());
                preparedStatement.setString(8, companyEntity.getSymbol());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    private void insertCompanies(Iterable<CompanyEntity> insertList, Connection dbConnection) {
        try (PreparedStatement preparedStatement = dbConnection.prepareStatement(
                "INSERT INTO company_profile (currency, description, displaysymbol, figi, mic, symbol, type)" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            for (CompanyEntity companyEntity : insertList) {
                preparedStatement.setString(1, companyEntity.getCurrency());
                preparedStatement.setString(2, companyEntity.getDescription());
                preparedStatement.setString(3, companyEntity.getDisplaySymbol());
                preparedStatement.setString(4, companyEntity.getFigi());
                preparedStatement.setString(5, companyEntity.getMic());
                preparedStatement.setString(6, companyEntity.getSymbol());
                preparedStatement.setString(7, companyEntity.getType());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    private void deleteCompanies(Iterable<String> deleteList, Connection dbConnection) {
        try (PreparedStatement preparedStatement = dbConnection.prepareStatement(
                "DELETE FROM company_profile WHERE symbol = ?")) {
            for (String companySymbol : deleteList) {
                preparedStatement.setString(1, companySymbol);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
