package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.model.Company;

public interface CompanyProfileDAO {

    Company getInfo(String companySymbol);

    void writeData(String data);
}
