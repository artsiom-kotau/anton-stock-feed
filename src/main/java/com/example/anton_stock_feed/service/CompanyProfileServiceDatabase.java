package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.model.Company;

public class CompanyProfileServiceDatabase implements CompanyProfileService{
    CompanyProfileDAO companyProfileDAO;

    public CompanyProfileServiceDatabase (CompanyProfileDAO companyProfileDAO) {
        this.companyProfileDAO = companyProfileDAO;
    }

    @Override
    public Company getInfo(String companySymbol) {
        return companyProfileDAO.getInfo(companySymbol);
    }
}
