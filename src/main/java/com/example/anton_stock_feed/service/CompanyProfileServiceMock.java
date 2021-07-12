package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.model.Company;

public class CompanyProfileServiceMock implements CompanyProfileService {
    private volatile static CompanyProfileServiceMock companyProfileServiceMock;
    CompanyProfileDAO companyProfileDAO;

    private CompanyProfileServiceMock(CompanyProfileDAO companyProfileDAO) {
        this.companyProfileDAO = companyProfileDAO;
    }

    public static CompanyProfileServiceMock getInstance(CompanyProfileDAO companyProfileDAO) {
        if (companyProfileServiceMock == null) {
            synchronized (CompanyProfileServiceMock.class) {
                if (companyProfileServiceMock == null) {
                    companyProfileServiceMock = new CompanyProfileServiceMock(companyProfileDAO);
                }
            }
        }
        return companyProfileServiceMock;
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
