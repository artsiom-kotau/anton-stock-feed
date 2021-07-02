package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.exceptions.DAOException;
import com.example.anton_stock_feed.model.Company;
import org.postgresql.jdbc.PgConnection;

import java.sql.*;

public class CompanyProfileDAODatabase implements CompanyProfileDAO {

    public CompanyProfileDAODatabase() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new DAOException(e);
        }
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
}
