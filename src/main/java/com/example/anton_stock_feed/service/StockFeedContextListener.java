package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.configuration.JavaConfiguration;
import com.example.anton_stock_feed.dao.CompanyProfileDAO;
import com.example.anton_stock_feed.dao.CompanyProfileDAOFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class StockFeedContextListener implements javax.servlet.ServletContextListener {
    ScheduledExecutorService ses;
    CompanyProfileDAO companyProfileDAO;
    CompanyProfileService companyProfileService;
    JsonSerialize jsonSerialize;
    APIService apiService;

    public StockFeedContextListener(JavaConfiguration javaConfiguration,
                                    CompanyProfileDAOFactory companyProfileDAOFactory,
                                    CompanyProfileServiceFactory companyProfileServiceFactory,
                                    JsonSerializeFactory jsonSerializeFactory,
                                    APIServiceFactory apiServiceFactory) {
        this.companyProfileDAO = companyProfileDAOFactory.createCompanyProfileDAO(javaConfiguration.getDAO());
        this.companyProfileService = companyProfileServiceFactory.createCompanyProfileService(javaConfiguration.getProfileService(), companyProfileDAO);
        this.jsonSerialize = jsonSerializeFactory.createJsonSerialize(javaConfiguration.getJsonSerialize());
        this.apiService = apiServiceFactory.createAPIService(javaConfiguration.getAPIService(), companyProfileService, jsonSerialize);
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ses = Executors.newSingleThreadScheduledExecutor();
        ses.scheduleWithFixedDelay(apiService::getInfo, 0, 10, TimeUnit.SECONDS);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ses.shutdown();
    }
}
