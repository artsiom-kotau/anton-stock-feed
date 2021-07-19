package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dao.CompanyProfileDAO;

public class CompanyProfileServiceFactory {

    public CompanyProfileService createCompanyProfileService(String type, CompanyProfileDAO companyProfileDAO) {
        CompanyProfileService companyProfileService = null;
        if (type.equals("Mock")) {
            companyProfileService = CompanyProfileServiceMock.getInstance(companyProfileDAO);
        } else if (type.equals("Database")) {
            companyProfileService = CompanyProfileServiceDatabase.getInstance(companyProfileDAO);
        }
        return companyProfileService;
    }
}
