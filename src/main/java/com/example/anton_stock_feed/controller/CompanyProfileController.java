package com.example.anton_stock_feed.controller;

import com.example.anton_stock_feed.configuration.JavaConfiguration;
import com.example.anton_stock_feed.dao.CompanyProfileDAO;
import com.example.anton_stock_feed.dao.CompanyProfileDAOFactory;
import com.example.anton_stock_feed.exceptions.CompanyProfileException;
import com.example.anton_stock_feed.model.Company;
import com.example.anton_stock_feed.service.CompanyProfileService;
import com.example.anton_stock_feed.service.CompanyProfileServiceFactory;
import com.example.anton_stock_feed.service.JsonSerialize;
import com.example.anton_stock_feed.service.JsonSerializeFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/company")
public class CompanyProfileController {
    CompanyProfileDAO companyProfileDAO;
    CompanyProfileService companyProfileService;
    JsonSerialize jsonSerialize;

    public CompanyProfileController(JavaConfiguration javaConfiguration,
                                    CompanyProfileDAOFactory companyProfileDAOFactory,
                                    CompanyProfileServiceFactory companyProfileServiceFactory,
                                    JsonSerializeFactory jsonSerializeFactory) {
        this.companyProfileDAO = companyProfileDAOFactory.createCompanyProfileDAO(javaConfiguration.getDAO());
        this.companyProfileService = companyProfileServiceFactory.createCompanyProfileService(javaConfiguration.getProfileService(), companyProfileDAO);
        this.jsonSerialize = jsonSerializeFactory.createJsonSerialize(javaConfiguration.getJsonSerialize());
    }

    @GetMapping
    public String list() {
        return "Enter company";
    }

    @GetMapping("{companyName}")
    public String getCompany(@PathVariable String companyName) {

        String responseString;
        Company company;

        try {
            company = companyProfileService.getInfo(companyName);
            responseString = jsonSerialize.serialize(company);
        } catch (Exception e) {
            throw new CompanyProfileException(e);
        }

        if (responseString.equals("null")) {
            return "No such company";
        }
        return responseString;
    }
}