package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.entity.CompanyEntity;

import java.util.Optional;

public interface CompanyProfileService {

    Optional<CompanyEntity> getInfo(String companySymbol);

    void writeData(Iterable<CompanyEntity> companies);
}
