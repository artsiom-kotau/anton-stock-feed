package com.example.anton_stock_feed.controller;

import com.example.anton_stock_feed.dto.ReportDto;
import com.example.anton_stock_feed.service.CompanyProfileService;
import com.example.anton_stock_feed.service.ReportService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/report/")
public class ReportPostController {
    ReportService reportService;
    CompanyProfileService companyProfileService;

    public ReportPostController(ReportService reportService,
                                CompanyProfileService companyProfileService) {
        this.reportService = reportService;
        this.companyProfileService = companyProfileService;
    }

    @PostMapping("/add/{symbol}")
    public Iterable<ReportDto> addReport(@RequestBody ReportDto reportDto, @PathVariable String symbol) {
        reportService.addReport(reportDto, symbol);
        return reportService.findBySymbol(symbol);
    }

    @DeleteMapping("/delete/{id}")
    public Iterable<ReportDto> deleteReport(@PathVariable Integer id) {
        reportService.deleteReport(id);
        return reportService.findAll();
    }

    @PutMapping("/update/{id}")
    public ReportDto updateReport(@RequestBody ReportDto reportDto, @PathVariable Integer id) {
        reportService.updateReport(reportDto, id);
        return reportService.findById(id);
    }
}