package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.configuration.JavaConfiguration;
import com.example.anton_stock_feed.dao.CompanyProfileDAO;
import com.example.anton_stock_feed.dao.CompanyProfileDAOFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class APIDataBySchedule {
    CompanyProfileDAO companyProfileDAO;
    CompanyProfileService companyProfileService;
    JsonSerialize jsonSerialize;
    APIService apiService;

    public APIDataBySchedule(JavaConfiguration javaConfiguration,
                             CompanyProfileDAOFactory companyProfileDAOFactory,
                             CompanyProfileServiceFactory companyProfileServiceFactory,
                             JsonSerializeFactory jsonSerializeFactory,
                             APIServiceFactory apiServiceFactory) {
        this.companyProfileDAO = companyProfileDAOFactory.createCompanyProfileDAO(javaConfiguration.getDAO());
        this.companyProfileService = companyProfileServiceFactory.createCompanyProfileService(javaConfiguration.getProfileService(), companyProfileDAO);
        this.jsonSerialize = jsonSerializeFactory.createJsonSerialize(javaConfiguration.getJsonSerialize());
        this.apiService = apiServiceFactory.createAPIService(javaConfiguration.getAPIService(), companyProfileService, jsonSerialize);
    }

    @Scheduled(fixedDelay = 5000L)
    public void getAPIData() {
        apiService.getInfo();
    }
}
