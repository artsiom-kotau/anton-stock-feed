package com.example.anton_stock_feed.controller;

import com.example.anton_stock_feed.dto.ReportDto;
import com.example.anton_stock_feed.service.CompanyProfileService;
import com.example.anton_stock_feed.service.ReportService;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public ReportDto addReport(@RequestBody ReportDto reportDto, @PathVariable String symbol) {
        return reportService.addReport(reportDto, symbol);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReport(@PathVariable Integer id) {
        reportService.deleteReport(id);
    }

    @PutMapping("/{id}")
    public ReportDto updateReport(@RequestBody ReportDto reportDto, @PathVariable Integer id) {
        return reportService.updateReport(reportDto, id);
    }
}