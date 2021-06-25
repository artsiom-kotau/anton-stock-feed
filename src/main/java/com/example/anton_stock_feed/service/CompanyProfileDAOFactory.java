package com.example.anton_stock_feed.service;

public class CompanyProfileDAOFactory {
    CompanyProfileDAO companyProfileDAO;

    public CompanyProfileDAO createCompanyProfileDAO(String type){
        if (type.equals("Mock")) {
            companyProfileDAO = new CompanyProfileDAOMock();
        }
        return companyProfileDAO;
    }
}
