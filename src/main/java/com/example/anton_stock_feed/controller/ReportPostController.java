package com.example.anton_stock_feed.controller;

import com.example.anton_stock_feed.dto.ReportDto;
import com.example.anton_stock_feed.service.CompanyProfileService;
import com.example.anton_stock_feed.service.ReportService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/add")
public class ReportPostController {
    ReportService reportService;
    CompanyProfileService companyProfileService;

    public ReportPostController(ReportService reportService,
                                CompanyProfileService companyProfileService) {
        this.reportService = reportService;
        this.companyProfileService = companyProfileService;
    }

    @PostMapping("/report/{symbol}")
    public Iterable<ReportDto> addReport(@RequestBody ReportDto reportDto, @PathVariable String symbol) {
        reportService.addReport(reportDto, symbol);
        return reportService.findBySymbol(symbol);
    }
}