package com.example.anton_stock_feed.controller;

import com.example.anton_stock_feed.dto.CompanyDetailsDto;
import com.example.anton_stock_feed.service.CompanyDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/companydetails/")
public class CompanyDetailsPostController {
    CompanyDetailsService companyDetailsService;

    public CompanyDetailsPostController(CompanyDetailsService companyDetailsService) {
        this.companyDetailsService = companyDetailsService;
    }

    @PostMapping("/add/{symbol}")
    @ResponseStatus(HttpStatus.CREATED)
    public Iterable<CompanyDetailsDto> addCompanyDetails(@RequestBody CompanyDetailsDto companyDetailsDto,
                                                         @PathVariable String symbol) {
        return companyDetailsService.addCompanyDetails(companyDetailsDto, symbol);
    }

//    @PostMapping("/add/{symbol}")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ReportDto addReport(@RequestBody ReportDto reportDto, @PathVariable String symbol) {
//        return reportService.addReport(reportDto, symbol);
//    }

}
