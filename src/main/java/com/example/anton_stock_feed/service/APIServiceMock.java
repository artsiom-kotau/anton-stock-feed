package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.model.Company;
import com.google.gson.Gson;

public class APIServiceMock implements APIService {
    CompanyProfileService companyProfileService;

    public APIServiceMock(CompanyProfileService companyProfileService) {
        this.companyProfileService = companyProfileService;
    }

    @Override
    public void getInfo() {
        String data = "{\"currency\":\"USD\",\"description\":\"MICROSOFT CORP\",\"displaySymbol\":\"MSFT\",\"figi\":\"BBG000BPH459\",\"mic\":\"XNAS\",\"symbol\":\"MSFT\",\"type\":\"Common Stock\"}";
        Company company = null;
        company = new Gson().fromJson(data, Company.class);
        companyProfileService.writeData(company);
    }

    public void run() {
        getInfo();
    }
}
