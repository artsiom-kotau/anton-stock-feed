package com.example.anton_stock_feed.classes;

import com.example.anton_stock_feed.model.CompanyClass;
import org.json.simple.JSONObject;

public interface CompanyProfileService {

    public abstract CompanyClass getInfo(String companySymbol);
}
