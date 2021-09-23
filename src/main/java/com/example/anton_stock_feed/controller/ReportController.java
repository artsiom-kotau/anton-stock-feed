package com.example.anton_stock_feed.controller;

import com.example.anton_stock_feed.dto.CompanyDto;
import com.example.anton_stock_feed.entity.ReportEntity;
import com.example.anton_stock_feed.service.CompanyProfileService;
import com.example.anton_stock_feed.service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("api/report")
public class ReportController {
    CompanyProfileService companyProfileService;
    ReportService reportService;

    public ReportController(CompanyProfileService companyProfileService,
                                    ReportService reportService) {
        this.companyProfileService = companyProfileService;
        this.reportService = reportService;
    }

    @GetMapping("{companyName}")
    public Collection<ReportEntity> getCompany(@PathVariable String companyName) {
        return reportService.findBySymbol(companyName);
    }
}