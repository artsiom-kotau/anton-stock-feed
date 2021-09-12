package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.entity.CompanyEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;

@EnableScheduling
@Component
public class APIDataBySchedule {
    APIService apiService;

    public APIDataBySchedule(APIService apiService) {
        this.apiService = apiService;
    }

    @Scheduled(fixedDelay = 1000000000L)
    public void getAPIData() {
        apiService.getInfo();
    }

    @Scheduled(fixedDelay = 10000L)
    public void writeApiData() {
        apiService.getInfo();
    }
}
