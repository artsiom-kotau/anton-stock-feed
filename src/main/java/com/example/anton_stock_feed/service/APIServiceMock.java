package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.entity.CompanyEntity;

import java.util.Collection;

public class APIServiceMock implements APIService {
    CompanyProfileService companyProfileService;
    JsonSerialize jsonSerialize;

    public APIServiceMock(CompanyProfileService companyProfileService, JsonSerialize jsonSerialize) {
        this.companyProfileService = companyProfileService;
        this.jsonSerialize = jsonSerialize;
    }

    @Override
    public void getInfo() {
//        // Default data
//        String data = "[{\"currency\":\"USD\",\"description\":\"MICROSOFT CORP\",\"displaySymbol\":\"MSFT\",\"figi\":\"BBG000BPH459\",\"mic\":\"XNAS\",\"symbol\":\"MSFT\",\"type\":\"Common Stock\"}," +
//                "{\"currency\":\"USD\",\"description\":\"APPLE INC\",\"displaySymbol\":\"AAPL\",\"figi\":\"BBG000B9XRY4\",\"mic\":\"XNAS\",\"symbol\":\"AAPL\",\"type\":\"Common stock\"}]";

//        // Update data
//        String data = "[{\"currency\":\"USD\",\"description\":\"123\",\"displaySymbol\":\"123\",\"figi\":\"123\",\"mic\":\"123\",\"symbol\":\"TSLA\",\"type\":\"123\"}," +
//                "{\"currency\":\"USD\",\"description\":\"321\",\"displaySymbol\":\"321\",\"figi\":\"321\",\"mic\":\"321\",\"symbol\":\"AAPL\",\"type\":\"321\"}]";

//        // Delete data
//        String data = "[{\"currency\":\"USD\",\"description\":\"TESLA INC\",\"displaySymbol\":\"TSLA\",\"figi\":\"BBG000N9MNX3\",\"mic\":\"XNAS\",\"symbol\":\"TSLA\",\"type\":\"Common Stock\"}]";

        // Insert data
        String data = "[{\"currency\":\"USD\",\"description\":\"MICROSOFT CORP\",\"displaySymbol\":\"MSFT\",\"figi\":\"BBG000BPH459\",\"mic\":\"XNAS\",\"symbol\":\"MSFT\",\"type\":\"Common Stock\"}," +
                "{\"currency\":\"USD\",\"description\":\"APPLE INC\",\"displaySymbol\":\"AAPL\",\"figi\":\"BBG000B9XRY4\",\"mic\":\"XNAS\",\"symbol\":\"AAPL\",\"type\":\"Common stock\"}," +
                "{\"currency\":\"USD\",\"description\":\"TESLA INC\",\"displaySymbol\":\"TSLA\",\"figi\":\"BBG000N9MNX3\",\"mic\":\"XNAS\",\"symbol\":\"TSLA\",\"type\":\"Common Stock\"}]";

        Collection<CompanyEntity> companies = jsonSerialize.deserializeToCollection(data, CompanyEntity.class);
        companyProfileService.writeData(companies);
    }

    public void run() {
        getInfo();
    }
}
