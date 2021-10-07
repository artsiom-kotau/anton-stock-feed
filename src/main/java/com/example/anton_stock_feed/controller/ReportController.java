package com.example.anton_stock_feed.controller;

import com.example.anton_stock_feed.dto.ReportDto;
import com.example.anton_stock_feed.service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/report")
public class ReportController {
    ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("{companyName}")
    public Iterable<ReportDto> getReport(@PathVariable String companyName) {
        return reportService.findBySymbol(companyName);
    }

}