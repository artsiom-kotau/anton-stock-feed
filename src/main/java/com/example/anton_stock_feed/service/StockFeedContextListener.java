package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dao.CompanyProfileDAO;
import com.example.anton_stock_feed.dao.CompanyProfileDAODatabase;
import com.example.anton_stock_feed.dao.CompanyProfileDAOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;
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

    public StockFeedContextListener(CompanyProfileDAODatabase companyProfileDAO,
                                    CompanyProfileServiceDatabase companyProfileService,
                                    JsonSerialize jsonSerialize,
                                    APIService apiService) {
        this.companyProfileDAO = companyProfileDAO;
        this.companyProfileService = companyProfileService;
        this.jsonSerialize = jsonSerialize;
        this.apiService = apiService;
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
