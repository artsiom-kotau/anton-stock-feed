package com.example.anton_stock_feed.classes;

import com.example.anton_stock_feed.model.CompanyClass;

public interface CompanyProfileDAO {

    CompanyClass getInfo(String companySymbol);
}
