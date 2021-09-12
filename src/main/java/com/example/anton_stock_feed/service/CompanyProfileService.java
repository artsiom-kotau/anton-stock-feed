package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dto.CompanyDto;
import com.example.anton_stock_feed.entity.CompanyEntity;

import java.util.Optional;

public interface CompanyProfileService {

    CompanyDto findById(Integer id);

    CompanyDto findByDisplaySymbol(String displaySymbol);

    Iterable<CompanyDto> findAll();

    void save(Iterable<CompanyEntity> companies);

    void writeData(Iterable<CompanyDto> apiCompanies);
}
