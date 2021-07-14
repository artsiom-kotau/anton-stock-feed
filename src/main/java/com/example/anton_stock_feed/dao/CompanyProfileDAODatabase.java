package com.example.anton_stock_feed.dao;

import com.example.anton_stock_feed.exceptions.DAOException;
import com.example.anton_stock_feed.model.Company;

import java.sql.*;

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
    public void writeData(Iterable<Company> companies) {
        try (Connection dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/stockfeed",
                "postgres",
                "PedbbRw4");
             PreparedStatement preparedStatement = dbConnection.prepareStatement(
                     "INSERT INTO company_profile (currency, description, displaysymbol, figi, mic, symbol, type)" +
                             "VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            dbConnection.setAutoCommit(false);

            for (Company company : companies) {
                preparedStatement.setString(1, company.getCurrency());
                preparedStatement.setString(2, company.getDescription());
                preparedStatement.setString(3, company.getDisplaysymbol());
                preparedStatement.setString(4, company.getFigi());
                preparedStatement.setString(5, company.getMic());
                preparedStatement.setString(6, company.getSymbol());
                preparedStatement.setString(7, company.getType());
                preparedStatement.addBatch();
            }
            preparedStatement.executeUpdate();
            dbConnection.commit();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
