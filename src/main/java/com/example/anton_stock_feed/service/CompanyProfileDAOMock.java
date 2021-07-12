package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.model.Company;

public class CompanyProfileDAOMock implements CompanyProfileDAO {
    private volatile static CompanyProfileDAOMock companyProfileDAOMock;

    private CompanyProfileDAOMock() {

    }

    public static CompanyProfileDAOMock getInstance() {
        if (companyProfileDAOMock == null) {
            synchronized (CompanyProfileDAOMock.class) {
                if (companyProfileDAOMock == null) {
                    companyProfileDAOMock = new CompanyProfileDAOMock();
                }
            }
        }
        return companyProfileDAOMock;
    }

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

    @Override
    public void writeData(Iterable<Company> companies) {
        System.out.println("DAO level " + companies.toString());
    }
}
