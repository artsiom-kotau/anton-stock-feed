package com.example.anton_stock_feed.dao;

import com.example.anton_stock_feed.model.Company;

public interface CompanyProfileDAO {

    Company getInfo(String companySymbol);

    void writeData(Iterable<Company> companies);
}
