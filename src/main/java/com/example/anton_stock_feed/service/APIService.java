package com.example.anton_stock_feed.service;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class APIService {
    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static void main(String[] args) throws IOException {
        APIService example = new APIService();
        String response = example.run("https://finnhub.io/api/v1/stock/profile2?symbol=AAPL&token=c30vv6aad3idae6u5770");
        System.out.println(response);
    }
}