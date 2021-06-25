package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.model.Company;

public class CompanyProfileServiceMock implements CompanyProfileService {
    Company company;
    CompanyProfileDAO companyProfileDAO;

    @Override
    public Company getInfo(String companySymbol, CompanyProfileDAO companyProfileDAO) {
        this.companyProfileDAO = companyProfileDAO;
        company = companyProfileDAO.getInfo(companySymbol);
        return company;
    }
}
