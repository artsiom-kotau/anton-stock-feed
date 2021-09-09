package com.example.anton_stock_feed.controller;

import com.example.anton_stock_feed.dto.CompanyDto;
import com.example.anton_stock_feed.service.CompanyProfileServiceJpa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/company")
public class CompanyProfileController {
    CompanyProfileServiceJpa companyProfileServiceJpa;

    public CompanyProfileController(CompanyProfileServiceJpa companyProfileServiceJpa) {
        this.companyProfileServiceJpa = companyProfileServiceJpa;
    }

    @GetMapping
    public String list() {
        return "Enter company";
    }

    @GetMapping("{/all}")
    public Iterable<CompanyDto> getAllCompanies() {
        return companyProfileServiceJpa.findAll();
    }

    @GetMapping("{companyName}")
    public CompanyDto getCompany(@PathVariable String companyName) {
        return companyProfileServiceJpa.findByDisplaySymbol(companyName);
    }

}