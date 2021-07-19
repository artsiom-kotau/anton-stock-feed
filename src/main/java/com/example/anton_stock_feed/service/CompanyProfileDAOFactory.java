package com.example.anton_stock_feed.service;

public class CompanyProfileDAOFactory {

    public CompanyProfileDAO createCompanyProfileDAO(String type){
        CompanyProfileDAO companyProfileDAO = null;
        if (type.equals("Mock")) {
            companyProfileDAO = new CompanyProfileDAOMock();
        } else if (type.equals("Database")) {
            companyProfileDAO = new CompanyProfileDAODatabase();
        }
        return companyProfileDAO;
    }
}
