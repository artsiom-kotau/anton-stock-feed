package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.model.Company;

public class CompanyProfileServiceDatabase implements CompanyProfileService {
    private volatile static CompanyProfileServiceDatabase companyProfileServiceDatabase;
    CompanyProfileDAO companyProfileDAO;

    private CompanyProfileServiceDatabase(CompanyProfileDAO companyProfileDAO) {
        this.companyProfileDAO = companyProfileDAO;
    }

    public static CompanyProfileServiceDatabase getInstance(CompanyProfileDAO companyProfileDAO) {
        if (companyProfileServiceDatabase == null) {
            synchronized (CompanyProfileServiceDatabase.class) {
                if (companyProfileServiceDatabase == null) {
                    companyProfileServiceDatabase = new CompanyProfileServiceDatabase(companyProfileDAO);
                }
            }
        }
        return companyProfileServiceDatabase;
    }

    @Override
    public Company getInfo(String companySymbol) {
        return companyProfileDAO.getInfo(companySymbol);
    }

    @Override
    public void writeData(Iterable<Company> companies) {
        companyProfileDAO.writeData(companies);
    }
}
