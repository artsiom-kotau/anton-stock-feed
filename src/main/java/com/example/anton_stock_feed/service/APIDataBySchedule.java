package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dao.ReportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class APIDataBySchedule {
    APIService apiService;
    @Autowired
    ReportDao reportDao;

    public APIDataBySchedule(APIService apiService) {
        this.apiService = apiService;
    }

//    @Scheduled(fixedDelay = 10000L)
//    public void writeApiData() {
//        apiService.getCompanyProfile();
//    }

}
