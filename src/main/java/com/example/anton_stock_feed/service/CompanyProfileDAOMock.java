package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.model.Company;

public class CompanyProfileDAOMock implements CompanyProfileDAO{


    @Override
    public Company getInfo(String companySymbol) {
        Company company = null;
        if (companySymbol.equals("AAPL")) {
            company = new Company("USD", "APPLE INC", "AAPL", "BBG000B9XRY4", "XNAS", "AAPL", "Common Stock");
        } else if (companySymbol.equals("TSLA")) {
            company = new Company("USD", "TESLA INC", "TSLA", "BBG000N9MNX3", "XNAS", "TSLA", "Common Stock");
        }
        return company;
    }
}
