package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.model.Company;

public class CompanyProfileServiceMock implements CompanyProfileService {
    CompanyProfileDAO companyProfileDAO;

    public CompanyProfileServiceMock(CompanyProfileDAO companyProfileDAO) {
        this.companyProfileDAO = companyProfileDAO;
    }

    @Override
    public Company getInfo(String companySymbol) {
        return companyProfileDAO.getInfo(companySymbol);
    }
}
