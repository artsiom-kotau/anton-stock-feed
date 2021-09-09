package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dto.CompanyDto;
import com.example.anton_stock_feed.entity.CompanyEntity;

public interface CompanyProfileServiceJpa {

    CompanyDto findById(Integer id);

    CompanyDto findByDisplaySymbol(String displaySymbol);

    Iterable<CompanyDto> findAll();

    void save(Iterable<CompanyEntity> companies);
}
