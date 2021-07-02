package com.example.anton_stock_feed.service;

public class CompanyProfileServiceFactory {

    public CompanyProfileService createCompanyProfileService(String type, CompanyProfileDAO companyProfileDAO) {
        CompanyProfileService companyProfileService = null;
        if (type.equals("Mock")) {
            companyProfileService = new CompanyProfileServiceMock(companyProfileDAO);
        } else if (type.equals("Database")) {
            companyProfileService = new CompanyProfileServiceDatabase(companyProfileDAO);
        }
        return companyProfileService;
    }
}
