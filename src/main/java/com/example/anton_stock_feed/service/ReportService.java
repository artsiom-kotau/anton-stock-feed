package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.entity.ReportEntity;

import java.util.Collection;

public interface ReportService {

    Collection<ReportEntity> findBySymbol(String symbol);

    void save(Iterable<ReportEntity> apiReports);
}
