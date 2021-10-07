package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dto.CompanyDetailsDto;

public interface CompanyDetailsService {

    Iterable<CompanyDetailsDto> findBySymbol(String symbol);
}