package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dao.ReportDao;
import com.example.anton_stock_feed.entity.ReportEntity;

import javax.transaction.Transactional;
import java.util.Collection;

public class ReportServiceImpl implements ReportService{
    ReportDao reportDao;

    public ReportServiceImpl(ReportDao reportDao) {
        this.reportDao = reportDao;
    }

    @Transactional
    @Override
    public Collection<ReportEntity> findBySymbol(String symbol) {
        return reportDao.findReportEntitiesBySymbol(symbol);
    }

    @Override
    public void save(Iterable<ReportEntity> apiReports) {
        reportDao.saveAll(apiReports);
    }
}
