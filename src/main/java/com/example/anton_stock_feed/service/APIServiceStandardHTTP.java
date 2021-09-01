package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.exceptions.APIServiceException;
import com.example.anton_stock_feed.model.Company;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collection;

public class APIServiceStandardHTTP implements APIService {

    CompanyProfileService companyProfileService;
    JsonSerialize jsonSerialize;

    public APIServiceStandardHTTP(CompanyProfileService companyProfileService, JsonSerialize jsonSerialize) {
        this.companyProfileService = companyProfileService;
        this.jsonSerialize = jsonSerialize;
    }

    @Override
    public void getInfo() {

        String uri = "https://finnhub.io/api/v1/stock/symbol?exchange=US&mic=XNYS&token=c30vv6aad3idae6u5770";
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

        Collection<Company> companies = jsonSerialize.deserializeToCollection(response.body(), Company.class);
        companyProfileService.writeData(companies);
    }

    public void run() {
        getInfo();
    }
}
