package com.example.anton_stock_feed.service;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class APIDataBySchedule {
    APIService apiService;

    public APIDataBySchedule(APIService apiService) {
        this.apiService = apiService;
    }

//    @Scheduled(fixedDelay = 10000L)
//    public void writeApiData() {
//        apiService.getCompanyProfile();
//    }

}
