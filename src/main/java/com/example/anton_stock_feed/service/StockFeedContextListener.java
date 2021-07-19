package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dao.CompanyProfileDAO;
import com.example.anton_stock_feed.dao.CompanyProfileDAOFactory;

import javax.servlet.ServletContextEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StockFeedContextListener implements javax.servlet.ServletContextListener {
    ScheduledExecutorService ses;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        CompanyProfileDAOFactory companyProfileDAOFactory = new CompanyProfileDAOFactory();
        CompanyProfileDAO companyProfileDAO = companyProfileDAOFactory.createCompanyProfileDAO("Database");
        CompanyProfileServiceFactory companyProfileServiceFactory = new CompanyProfileServiceFactory();
        CompanyProfileService companyProfileService = companyProfileServiceFactory.createCompanyProfileService("Database", companyProfileDAO);
        JsonSerializeFactory jsonSerializeFactory = new JsonSerializeFactory();
        JsonSerialize jsonSerialize = jsonSerializeFactory.createJsonSerialize("Gson");

        APIServiceFactory apiServiceFactory = new APIServiceFactory();
        APIService apiService = apiServiceFactory.createAPIService("Mock", companyProfileService, jsonSerialize);
        ses = Executors.newSingleThreadScheduledExecutor();
        ses.scheduleWithFixedDelay(apiService::getInfo, 0, 10, TimeUnit.SECONDS);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ses.shutdown();
    }
}
