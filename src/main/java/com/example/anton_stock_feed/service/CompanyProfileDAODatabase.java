package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.model.Company;
import org.postgresql.jdbc.PgConnection;

import java.sql.*;

public class CompanyProfileDAODatabase implements CompanyProfileDAO{

    @Override
    public Company getInfo(String companySymbol) {
        Company company = null;

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {

        }

        try {
            Connection dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/stockfeed",
                    "postgres",
                    "PedbbRw4");
            Statement statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM company_profile");
            while (rs.next()) {
                String symbol = rs.getString("symbol");
                if (symbol.equals(companySymbol)) {

                    String currency = rs.getString("currency");
                    String description = rs.getString("description");
                    String displaysymbol = rs.getString("displaysymbol");
                    String figi = rs.getString("figi");
                    String mic = rs.getString("mic");
                    String type = rs.getString("type");

                    company = new Company(currency, description, displaysymbol, figi, mic, symbol, type);
                }
            }
        } catch (SQLException throwables) {

        }
        return company;
    }
}
