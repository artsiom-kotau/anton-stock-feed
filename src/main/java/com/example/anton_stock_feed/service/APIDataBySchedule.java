package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.entity.CompanyDetailsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class APIDataBySchedule {
    APIService apiService;

    @Autowired
    CompanyDetailsService companyDetailsService;

    public APIDataBySchedule(APIService apiService) {
        this.apiService = apiService;
    }

    @Scheduled(fixedDelay = 10000L)
    public void writeApiData() {
        //apiService.getCompanyProfile();

        Iterable<CompanyDetailsEntity> companyDetailsEntities = companyDetailsService.findBySymbol("AAPL");
        System.out.println(companyDetailsEntities);
    }


}
