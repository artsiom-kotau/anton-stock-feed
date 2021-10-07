package com.example.anton_stock_feed.controller;

import com.example.anton_stock_feed.dto.CompanyDetailsDto;
import com.example.anton_stock_feed.service.CompanyDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/companydetails")
public class CompanyDetailsController {

    CompanyDetailsService companyDetailsService;

    public CompanyDetailsController(CompanyDetailsService companyDetailsService) {
        this.companyDetailsService = companyDetailsService;
    }

    @GetMapping("{companyName}")
    public Iterable<CompanyDetailsDto> getCompanyDetails(@PathVariable String companyName) {
        return companyDetailsService.findBySymbol(companyName);
    }

}