package com.example.anton_stock_feed.dao;

import org.springframework.stereotype.Component;

@Component
public class CompanyProfileDAOFactory {

    public CompanyProfileDAO createCompanyProfileDAO(String type) {
        CompanyProfileDAO companyProfileDAO = null;
        if (type.equals("Mock")) {
            companyProfileDAO = CompanyProfileDAOMock.getInstance();
        } else if (type.equals("Database")) {
            companyProfileDAO = CompanyProfileDAODatabase.getInstance();
        }
        return companyProfileDAO;
    }
}
