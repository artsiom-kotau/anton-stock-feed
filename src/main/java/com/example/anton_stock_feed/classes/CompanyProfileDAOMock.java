package com.example.anton_stock_feed.classes;

import com.example.anton_stock_feed.model.CompanyClass;

public class CompanyProfileDAOMock implements CompanyProfileDAO{
    CompanyClass companyClass;

    @Override
    public CompanyClass getInfo(String companySymbol) {
        if (companySymbol.equals("AAPL")) {
            companyClass = new CompanyClass("USD", "APPLE INC", "AAPL", "BBG000B9XRY4", "XNAS", "AAPL", "Common Stock");
        } else if (companySymbol.equals("TSLA")) {
            companyClass = new CompanyClass("USD", "TESLA INC", "TSLA", "BBG000N9MNX3", "XNAS", "TSLA", "Common Stock");
        }
        return companyClass;
    }
}
