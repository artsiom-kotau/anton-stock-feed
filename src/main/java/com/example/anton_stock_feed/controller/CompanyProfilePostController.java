package com.example.anton_stock_feed.controller;

import com.example.anton_stock_feed.dao.ReportDao;
import com.example.anton_stock_feed.dto.CompanyDto;
import com.example.anton_stock_feed.dto.ReportDto;
import com.example.anton_stock_feed.entity.CompanyEntity;
import com.example.anton_stock_feed.entity.ReportEntity;
import com.example.anton_stock_feed.mappers.CompanyMapper;
import com.example.anton_stock_feed.mappers.ReportMapper;
import com.example.anton_stock_feed.service.CompanyProfileService;
import com.example.anton_stock_feed.service.ReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/add")
public class CompanyProfilePostController {
    CompanyProfileService companyProfileService;
    ReportService reportService;
    ReportDao reportDao;
    ReportMapper reportMapper;
    CompanyMapper companyMapper;

    public CompanyProfilePostController(CompanyProfileService companyProfileService,
                                        ReportDao reportDao,
                                        ReportService reportService,
                                        ReportMapper reportMapper,
                                        CompanyMapper companyMapper) {
        this.companyProfileService = companyProfileService;
        this.reportDao = reportDao;
        this.reportService = reportService;
        this.reportMapper = reportMapper;
        this.companyMapper = companyMapper;
    }

    @PostMapping("/report")
    public CompanyDto addReport(@RequestBody ReportEntity requestReportEntity, @RequestParam String symbol) {
        CompanyDto companyDto = companyProfileService.findByDisplaySymbol(symbol);
        List<ReportDto> reportDtos = companyDto.getReports();

        ReportDto reportDto = reportMapper.toDto(requestReportEntity);
        reportDtos.add(reportDto);
        companyDto.setReports(reportDtos);
        CompanyEntity companyEntity = companyMapper.toEntity(companyDto);
        companyProfileService.save(companyEntity);
        return companyDto;
    }

//    @PostMapping("/basicfinancials")
//    public BasicFinancialsDto addBasicFinancials(@RequestBody BasicFinancialsEntity basicFinancialsEntity,
//                                                 @RequestParam String symbol) {
//        CompanyDto companyDto = companyProfileService.findByDisplaySymbol(symbol);
//
//    }
}