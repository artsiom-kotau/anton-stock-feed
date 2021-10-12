package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dto.ReportDto;
import com.example.anton_stock_feed.entity.ReportEntity;

public interface ReportService {

    ReportDto findById(Integer id);

    Iterable<ReportDto> findBySymbol(String symbol);

    Iterable<ReportDto> findAll();

    void saveAll(Iterable<ReportEntity> apiReports);

    <S extends ReportEntity> S save(S entity);

    void addReport(ReportDto reportDto, String symbol);

    void deleteReport(Integer id);

    void updateReport(ReportDto reportDto, Integer id);

}
