package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dao.CompanyDetailsDao;
import com.example.anton_stock_feed.entity.CompanyDetailsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CompanyDetailsServiceImpl implements CompanyDetailsService{
    @Autowired
    CompanyDetailsDao companyDetailsDao;


    @Override
    public Iterable<CompanyDetailsEntity> findBySymbol(String symbol) {
        Collection<CompanyDetailsEntity> companyDetailsEntities = companyDetailsDao.findCompanyDetailsEntitiesBySymbol(symbol);
        return companyDetailsEntities;
    }
}
