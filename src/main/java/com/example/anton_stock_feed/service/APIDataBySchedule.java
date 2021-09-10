package com.example.anton_stock_feed.service;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class APIDataBySchedule {
    APIService apiService;

    public APIDataBySchedule(APIService apiService) {
        this.apiService = apiService;
    }

//    @Scheduled(fixedDelay = 1000000000L)
//    public void getAPIData() {
//        apiService.getInfo();
//    }
}
