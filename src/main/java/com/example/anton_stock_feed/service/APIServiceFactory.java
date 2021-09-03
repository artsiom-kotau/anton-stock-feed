package com.example.anton_stock_feed.service;

import org.springframework.stereotype.Component;

@Component
public class APIServiceFactory {
    public APIService createAPIService(String type, CompanyProfileServiceInterface companyProfileServiceInterface, JsonSerialize jsonSerialize) {
        APIService apiService = null;
        if (type.equals("StandardHTTP")) {
            apiService = new APIServiceStandardHTTP(companyProfileServiceInterface, jsonSerialize);
        } else if (type.equals("Mock")) {
            apiService = new APIServiceMock(companyProfileServiceInterface, jsonSerialize);
        }
        return apiService;
    }
}
