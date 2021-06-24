package com.example.anton_stock_feed.classes;

import com.example.anton_stock_feed.model.CompanyClass;

public class CompanyProfileServiceMock implements CompanyProfileService {
    CompanyClass companyClass;
    CompanyProfileDAO companyProfileDAO;

    @Override
    public CompanyClass getInfo(String companySymbol, CompanyProfileDAO companyProfileDAO) {
        this.companyProfileDAO = companyProfileDAO;
        companyClass = companyProfileDAO.getInfo(companySymbol);
        return companyClass;
    }
}
