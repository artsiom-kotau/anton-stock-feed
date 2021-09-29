package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dao.ReportDao;
import com.example.anton_stock_feed.dto.ReportDto;
import com.example.anton_stock_feed.entity.ReportEntity;

import javax.transaction.Transactional;
import java.util.Collection;

public class ReportServiceImpl implements ReportService{
    ReportDao reportDao;
    ReportMapper reportMapper;

    public ReportServiceImpl(ReportDao reportDao) {
        this.reportDao = reportDao;
    }

    @Transactional
    @Override
    public Iterable<ReportDto> findBySymbol(String symbol) {
        Collection<ReportEntity> reportEntities = reportDao.findReportEntitiesBySymbol(symbol);
        Iterable<ReportDto> reportDtos = reportMapper.companiesToCompanyDtos(reportEntities);      //map(reportMapper::toDto).orElse(null);
        return reportDtos;
    }

//    @Transactional
//    @Override
//    public Collection<ReportEntity> findBySymbol(String symbol) {
//        return reportDao.findReportEntitiesBySymbol(symbol);
//    }

    //    @Transactional
//    @Override
//    public CompanyDto findByDisplaySymbol(String displaySymbol) {
//        Optional<CompanyEntity> company = companyProfileDao.findAllByDisplaySymbol(displaySymbol);
//        return company.map(companyMapper::toDto).orElse(null);
//    }

    @Override
    public void save(Iterable<ReportEntity> apiReports) {
        reportDao.saveAll(apiReports);
    }
}
