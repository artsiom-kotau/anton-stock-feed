package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.entity.CompanyDetailsEntity;

public interface CompanyDetailsService {

    Iterable<CompanyDetailsEntity> findBySymbol(String symbol);
}
