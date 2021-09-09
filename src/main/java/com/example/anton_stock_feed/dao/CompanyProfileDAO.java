package com.example.anton_stock_feed.dao;

import com.example.anton_stock_feed.entity.CompanyEntity;

import java.util.Optional;

public interface CompanyProfileDAO {

    Optional<CompanyEntity> getInfo(String companySymbol);

    void writeData(Iterable<CompanyEntity> companies);
}
