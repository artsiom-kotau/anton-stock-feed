package com.example.anton_stock_feed.dao;

import com.example.anton_stock_feed.entity.CompanyEntity;

import java.util.Optional;

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
    public Optional<CompanyEntity> getInfo(String companySymbol) {
        CompanyEntity companyEntity = null;
        if (companySymbol.equals("AAPL")) {
            companyEntity = new CompanyEntity("USD", "APPLE INC", "AAPL", "BBG000B9XRY4", "XNAS", "AAPL", "Common Stock");
        } else if (companySymbol.equals("TSLA")) {
            companyEntity = new CompanyEntity("USD", "TESLA INC", "TSLA", "BBG000N9MNX3", "XNAS", "TSLA", "Common Stock");
        }
        return Optional.ofNullable(companyEntity);
    }

    @Override
    public void writeData(Iterable<CompanyEntity> companies) {
        System.out.println("DAO level " + companies.toString());
    }
}
