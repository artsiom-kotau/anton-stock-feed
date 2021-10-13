package com.example.anton_stock_feed.controller;

import com.example.anton_stock_feed.dto.CreateCompanyDetailsRequestDto;
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
    public void addCompanyDetails(
            @RequestBody CreateCompanyDetailsRequestDto createCompanyDetailsRequestDto,
            @PathVariable String symbol) {
        companyDetailsService.addCompanyDetailsToOneEntity(createCompanyDetailsRequestDto, symbol);
    }

}
