package com.example.anton_stock_feed;

import java.io.PrintWriter;
import java.sql.*;

public class DatabaseToController {
    //String info = "{\"country\":\"US\",\"currency\":\"USD\",\"exchange\":\"NASDAQ NMS - GLOBAL MARKET\",\"finnhubIndustry\":\"Technology\",\"ipo\":\"1980-12-12\",\"logo\":\"https://finnhub.io/api/logo?symbol=AAPL\",\"marketCapitalization\":2163385,\"name\":\"Apple Inc\",\"phone\":\"14089961010.0\",\"shareOutstanding\":16687.631,\"ticker\":\"AAPL\",\"weburl\":\"https://www.apple.com/\"}";
    String info;

    public String getInfo() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/stockfeed",
                    "postgres", "PedbbRw4");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM company_profile");

            while (resultSet.next()) {
                int id;
                String currency;
                String description;
                String displaysymbol;
                String figi;
                String mic;
                String symbol;
                String type;

                id = resultSet.getInt("id");
                currency = resultSet.getString("currency");
                description = resultSet.getString("description");
                displaysymbol = resultSet.getString("displaysymbol");
                figi = resultSet.getString("figi");
                mic = resultSet.getString("mic");
                symbol = resultSet.getString("symbol");
                type = resultSet.getString("type");

                info = "id: " + id + ", currency: " + currency + ", description: " + description + ", display symbol: " +
                        displaysymbol + ", figi: " + figi + ", mic: " + mic + ", symbol: " + symbol + ", type: " + type;
            }

            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return info;
    }


}
