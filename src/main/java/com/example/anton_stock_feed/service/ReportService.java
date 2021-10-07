package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dto.ReportDto;
import com.example.anton_stock_feed.entity.ReportEntity;

public interface ReportService {

    Iterable<ReportDto> findBySymbol(String symbol);

    void saveAll(Iterable<ReportEntity> apiReports);

    <S extends ReportEntity> S save(S entity);
}
