package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dto.BasicFinancialsDto;

public interface BasicFinancialsService{

    BasicFinancialsDto findBySymbol(String symbol);
}
