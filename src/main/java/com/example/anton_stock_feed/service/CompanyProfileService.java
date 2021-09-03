package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dao.CompanyProfileDAO;
import com.example.anton_stock_feed.model.Company;
import org.springframework.stereotype.Component;

public class CompanyProfileService implements CompanyProfileServiceInterface {
    CompanyProfileDAO companyProfileDAO;

    public CompanyProfileService(CompanyProfileDAO companyProfileDAO) {
        this.companyProfileDAO = companyProfileDAO;
    }

    @Override
    public Company getInfo(String companySymbol) {
        return companyProfileDAO.getInfo(companySymbol);
    }

    @Override
    public void writeData(Iterable<Company> companies) {
        companyProfileDAO.writeData(companies);
    }
}
