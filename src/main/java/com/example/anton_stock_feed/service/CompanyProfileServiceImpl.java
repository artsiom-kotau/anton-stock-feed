package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dao.CompanyProfileDAO;
import com.example.anton_stock_feed.entity.CompanyEntity;

import java.util.Optional;

public class CompanyProfileServiceImpl implements CompanyProfileService {
    CompanyProfileDAO companyProfileDAO;

    public CompanyProfileServiceImpl(CompanyProfileDAO companyProfileDAO) {
        this.companyProfileDAO = companyProfileDAO;
    }

    @Override
    public Optional<CompanyEntity> getInfo(String companySymbol) {
        return companyProfileDAO.getInfo(companySymbol);
    }

    @Override
    public void writeData(Iterable<CompanyEntity> companies) {
        companyProfileDAO.writeData(companies);
    }
}
