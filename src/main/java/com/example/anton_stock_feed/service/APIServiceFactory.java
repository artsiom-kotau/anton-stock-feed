package com.example.anton_stock_feed.service;

public class APIServiceFactory {
    public APIService createAPIService(String type, CompanyProfileService companyProfileService, JsonSerialize jsonSerialize) {
        APIService apiService = null;
        if (type.equals("StandardHTTP")) {
            apiService = new APIServiceStandardHTTP(companyProfileService, jsonSerialize);
        } else if (type.equals("Mock")) {
            apiService = new APIServiceMock(companyProfileService, jsonSerialize);
        }
        return apiService;
    }
}
