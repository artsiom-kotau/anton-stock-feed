package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.model.Company;

public interface CompanyProfileService {

    Company getInfo(String companySymbol);
}
