package com.example.anton_stock_feed.service;

import javax.servlet.ServletContextEvent;
import java.util.concurrent.ExecutorService;
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

        APIServiceFactory apiServiceFactory = new APIServiceFactory();
        APIService apiService = apiServiceFactory.createAPIService("Mock", companyProfileService);
        ses = Executors.newSingleThreadScheduledExecutor();
        ses.scheduleWithFixedDelay(apiService, 0, 10, TimeUnit.SECONDS);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ses.shutdown();
    }
}
