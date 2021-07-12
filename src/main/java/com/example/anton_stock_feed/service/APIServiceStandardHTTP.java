package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.exceptions.APIServiceException;
import com.example.anton_stock_feed.model.Company;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collection;

public class APIServiceStandardHTTP implements APIService {
    CompanyProfileService companyProfileService;

    public APIServiceStandardHTTP(CompanyProfileService companyProfileService) {
        this.companyProfileService = companyProfileService;
    }

    @Override
    public void getInfo() {
        String uri = "https://finnhub.io/api/v1/stock/profile2?symbol=MSFT&token=c30vv6aad3idae6u5770";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new APIServiceException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Type companyListType = new TypeToken<Collection<Company>>() {
        }.getType();
        ArrayList<Company> companies = new Gson().fromJson(response.body(), companyListType);
        companyProfileService.writeData(companies);
    }

    public void run() {
        getInfo();
    }
}
