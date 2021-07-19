package com.example.anton_stock_feed.dao;

import com.example.anton_stock_feed.exceptions.DAOException;
import com.example.anton_stock_feed.model.Company;

import java.sql.*;
import java.util.Collection;
import java.util.HashSet;

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
    public Company getInfo(String companySymbol) {
        Company company = null;

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

                company = new Company(currency, description, displaysymbol, figi, mic, symbol, type);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return company;
    }

    @Override
    public void writeData(Iterable<Company> apiCompanies) {
        Collection<String> companySymbolsDatabase = new HashSet<String>();
        Collection<Company> insertCompanies = new HashSet<Company>();
        Collection<String> insertUpdateCompanies = new HashSet<String>();
        Collection<Company> updateCompanies = new HashSet<Company>();
        Collection<String> deleteCompanies = new HashSet<String>();

        try (Connection dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/stockfeed",
                "postgres",
                "PedbbRw4")) {
            dbConnection.setAutoCommit(false);

            try {
                companySymbolsDatabase = (HashSet<String>) this.checkAvailability(dbConnection);
                for (Company company : apiCompanies) {
                    String companySymbol = company.getSymbol();
                    if (companySymbolsDatabase.contains(companySymbol)) {
                        updateCompanies.add(company);
                    } else {
                        insertCompanies.add(company);
                    }
                }

                for (Company company : insertCompanies) {
                    insertUpdateCompanies.add(company.getSymbol());
                }
                for (Company company : updateCompanies) {
                    insertUpdateCompanies.add(company.getSymbol());
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

    public Iterable checkAvailability(Connection dbConnection) {
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

    public void updateCompanies(Iterable<Company> updateList, Connection dbConnection) {
        try (PreparedStatement preparedStatement = dbConnection.prepareStatement(
                "UPDATE company_profile SET currency=?, description=?, displaysymbol=?, figi=?, mic=?, symbol=?, type=? WHERE symbol=?")) {
            for (Company company : updateList) {
                preparedStatement.setString(1, company.getCurrency());
                preparedStatement.setString(2, company.getDescription());
                preparedStatement.setString(3, company.getDisplaySymbol());
                preparedStatement.setString(4, company.getFigi());
                preparedStatement.setString(5, company.getMic());
                preparedStatement.setString(6, company.getSymbol());
                preparedStatement.setString(7, company.getType());
                preparedStatement.setString(8, company.getSymbol());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public void insertCompanies(Iterable<Company> insertList, Connection dbConnection) {
        try (PreparedStatement preparedStatement = dbConnection.prepareStatement(
                "INSERT INTO company_profile (currency, description, displaysymbol, figi, mic, symbol, type)" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            for (Company company : insertList) {
                preparedStatement.setString(1, company.getCurrency());
                preparedStatement.setString(2, company.getDescription());
                preparedStatement.setString(3, company.getDisplaySymbol());
                preparedStatement.setString(4, company.getFigi());
                preparedStatement.setString(5, company.getMic());
                preparedStatement.setString(6, company.getSymbol());
                preparedStatement.setString(7, company.getType());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public void deleteCompanies(Iterable<String> deleteList, Connection dbConnection) {
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
