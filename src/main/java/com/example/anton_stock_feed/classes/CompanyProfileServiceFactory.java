package com.example.anton_stock_feed.classes;

public class CompanyProfileServiceFactory {
    CompanyProfileService companyProfileService;

    public CompanyProfileService createCompanyProfileService(String type) {
        if (type.equals("Mock")) {
            companyProfileService = new CompanyProfileServiceMock();
        }
        return companyProfileService;
    }
}
