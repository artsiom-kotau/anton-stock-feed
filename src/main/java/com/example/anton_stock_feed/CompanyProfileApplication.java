package com.example.anton_stock_feed;

import com.example.anton_stock_feed.service.ReportService;
import com.example.anton_stock_feed.service.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class CompanyProfileApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanyProfileApplication.class, args);
    }
}
