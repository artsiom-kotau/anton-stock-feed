package com.example.anton_stock_feed.controller;

import com.example.anton_stock_feed.dao.CompanyProfileDAO;
import com.example.anton_stock_feed.model.Company;
import com.example.anton_stock_feed.repositories.CompanyRepository;
import com.example.anton_stock_feed.service.CompanyProfileServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/company")
public class CompanyProfileController {
    CompanyProfileDAO companyProfileDAO;
    CompanyProfileServiceInterface companyProfileService;
    CompanyRepository companyRepository;

    public CompanyProfileController(CompanyProfileDAO companyProfileDAO,
                                    CompanyProfileServiceInterface companyProfileService,
                                    CompanyRepository companyRepository) {
        this.companyProfileDAO = companyProfileDAO;
        this.companyProfileService = companyProfileService;
        this.companyRepository = companyRepository;
    }

    @GetMapping
    public String list() {
        return "Enter company";
    }

    @GetMapping("{companyName}")
    public Company getCompany(@PathVariable String companyName) {
        return companyProfileService.getInfo(companyName);
    }
}
