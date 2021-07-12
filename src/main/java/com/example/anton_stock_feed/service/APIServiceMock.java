package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.model.Company;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class APIServiceMock implements APIService {
    CompanyProfileService companyProfileService;

    public APIServiceMock(CompanyProfileService companyProfileService) {
        this.companyProfileService = companyProfileService;
    }

    @Override
    public void getInfo() {
        String data = "[{\"currency\":\"USD\",\"description\":\"MICROSOFT CORP\",\"displaySymbol\":\"MSFT\",\"figi\":\"BBG000BPH459\",\"mic\":\"XNAS\",\"symbol\":\"MSFT\",\"type\":\"Common Stock\"}," +
                "{\"currency\":\"USD\",\"description\":\"APPLE INC\",\"displaysymbol\":\"AAPL\",\"figi\":\"BBG000B9XRY4\",\"mic\":\"XNAS\",\"symbol\":\"AAPL\",\"type\":\"Common stock\"}]";

        Type companyListType = new TypeToken<Collection<Company>>() {
        }.getType();
        ArrayList<Company> companies = new Gson().fromJson(data, companyListType);
        companyProfileService.writeData(companies);
    }

    public void run() {
        getInfo();
    }
}
