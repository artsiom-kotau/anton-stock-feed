package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dao.ReportDao;
import com.example.anton_stock_feed.dto.ReportDto;
import com.example.anton_stock_feed.entity.CompanyEntity;
import com.example.anton_stock_feed.entity.ReportEntity;
import com.example.anton_stock_feed.mappers.ReportMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

public class ReportServiceImpl implements ReportService {
    ReportDao reportDao;
    ReportMapper reportMapper;
    CompanyProfileService companyProfileService;

    public ReportServiceImpl(ReportDao reportDao,
                             ReportMapper reportMapper,
                             CompanyProfileService companyProfileService) {
        this.reportDao = reportDao;
        this.reportMapper = reportMapper;
        this.companyProfileService = companyProfileService;
    }

    @Transactional
    @Override
    public ReportDto findById(Integer id) {
        Optional<ReportEntity> reportEntity = reportDao.findById(id);
        return reportEntity.map(reportMapper::toDto).orElse(null);
    }

    @Transactional
    @Override
    public Iterable<ReportDto> findBySymbol(String symbol) {
        Collection<ReportEntity> reportEntities = reportDao.findReportEntitiesBySymbol(symbol);
        Iterable<ReportDto> reportDtos = reportMapper.reportsToReportDtos(reportEntities);
        return reportDtos;
    }

    @Transactional
    @Override
    public Iterable<ReportDto> findAll() {
        Iterable<ReportEntity> reportEntities = reportDao.findAll();
        Iterable<ReportDto> reportDtos = reportMapper.reportsToReportDtos(reportEntities);
        return reportDtos;
    }

    @Transactional
    @Override
    public void saveAll(Iterable<ReportEntity> apiReports) {
        reportDao.saveAll(apiReports);
    }

    @Transactional
    @Override
    public <S extends ReportEntity> S save(S entity) {
        return reportDao.save(entity);
    }

    @Transactional
    @Override
    public void addReport(ReportDto reportDto, String symbol) {
        CompanyEntity companyEntity = companyProfileService.findCompanyEntityByDisplaySymbol(symbol);
        ReportEntity reportEntity = reportMapper.toEntity(reportDto);
        reportEntity.setCompany(companyEntity);
        reportDao.save(reportEntity);
    }

    @Transactional
    @Override
    public void deleteReport(Integer id) {
        if (reportDao.existsById(id)) {
            reportDao.deleteById(id);
        }
    }

    @Transactional
    @Override
    public void updateReport(ReportDto reportDto, Integer id) {
        if (reportDao.existsById(id)) {
            reportDto.setId(id);
            reportDao.save(reportMapper.toEntity(reportDto));
        }
    }
}
