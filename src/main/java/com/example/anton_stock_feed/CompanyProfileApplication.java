package com.example.anton_stock_feed;

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
