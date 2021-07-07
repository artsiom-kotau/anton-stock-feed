package com.example.anton_stock_feed.service;

public class APIServiceFactory {
    public APIService createAPIService(String type, CompanyProfileService companyProfileService) {
        APIService apiService = null;
        if (type.equals("StandardHTTP")) {
            apiService = new APIServiceStandardHTTP(companyProfileService);
        } else if (type.equals("Mock")) {
            apiService = new APIServiceMock(companyProfileService);
        }
        return apiService;
    }
}
