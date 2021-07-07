package com.example.anton_stock_feed.service;

public class APIServiceMock implements Runnable, APIService{
    CompanyProfileService companyProfileService;

    public APIServiceMock (CompanyProfileService companyProfileService) {
        this.companyProfileService = companyProfileService;
    }

    @Override
    public void getInfo() {
        String data = "{\"currency\":\"USD\",\"description\":\"MICROSOFT CORP\",\"displaySymbol\":\"MSFT\",\"figi\":\"BBG000BPH459\",\"mic\":\"XNAS\",\"symbol\":\"MSFT\",\"type\":\"Common Stock\"}";
        companyProfileService.writeData(data);
    }

    @Override
    public void run() {
        getInfo();
    }
}
