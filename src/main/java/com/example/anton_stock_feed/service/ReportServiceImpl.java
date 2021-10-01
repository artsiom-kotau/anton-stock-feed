package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dao.ReportDao;
import com.example.anton_stock_feed.dto.ReportDto;
import com.example.anton_stock_feed.entity.ReportEntity;

import javax.transaction.Transactional;
import java.util.Collection;

public class ReportServiceImpl implements ReportService{
    ReportDao reportDao;
    ReportMapper reportMapper;

    public ReportServiceImpl(ReportDao reportDao, ReportMapper reportMapper) {
        this.reportDao = reportDao;
        this.reportMapper = reportMapper;
    }

    @Transactional
    @Override
    public Iterable<ReportDto> findBySymbol(String symbol) {
        Collection<ReportEntity> reportEntities = reportDao.findReportEntitiesBySymbol(symbol);
        Iterable<ReportDto> reportDtos = reportMapper.reportsToReportDtos(reportEntities);      //map(reportMapper::toDto).orElse(null);
        return reportDtos;
    }

    @Override
    public void save(Iterable<ReportEntity> apiReports) {
        reportDao.saveAll(apiReports);
    }
}
