package com.example.anton_stock_feed.controller;

import com.example.anton_stock_feed.dto.CompanyDto;
import com.example.anton_stock_feed.service.CompanyProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/company")
public class CompanyProfileController {
    CompanyProfileService companyProfileService;

    public CompanyProfileController(CompanyProfileService companyProfileService) {
        this.companyProfileService = companyProfileService;
    }

    @GetMapping
    public String list() {
        return "Enter company";
    }

    @GetMapping("{/all}")
    public Iterable<CompanyDto> getAllCompanies() {
        return companyProfileService.findAll();
    }

    @GetMapping("{companyName}")
    public CompanyDto getCompany(@PathVariable String companyName) {
        return companyProfileService.findByDisplaySymbol(companyName);
    }

    @PostMapping
    public @ResponseBody String addReports(@RequestParam String report) {
        return report;
    }
}