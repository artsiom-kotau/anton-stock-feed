package com.example.anton_stock_feed.classes;

public class CompanyProfileDAOFactory {
    CompanyProfileDAO companyProfileDAO;

    public CompanyProfileDAO createCompanyProfileDAO(String type){
        if (type.equals("Mock")) {
            companyProfileDAO = new CompanyProfileDAOMock();
        }
        return companyProfileDAO;
    }
}
