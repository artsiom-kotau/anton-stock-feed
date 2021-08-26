package com.example.anton_stock_feed.controller;

import com.example.anton_stock_feed.dao.CompanyProfileDAO;
import com.example.anton_stock_feed.dao.CompanyProfileDAODatabase;
import com.example.anton_stock_feed.dao.CompanyProfileDAOFactory;
import com.example.anton_stock_feed.exceptions.CompanyProfileException;
import com.example.anton_stock_feed.model.Company;
import com.example.anton_stock_feed.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.PostConstruct;

@RestController
@RequestMapping("api/company")
public class CompanyProfileSB {
    CompanyProfileDAO companyProfileDAO;
    CompanyProfileService companyProfileService;
    JsonSerialize jsonSerialize;


    public CompanyProfileSB(JsonSerializeGson jsonSerialize, CompanyProfileServiceDatabase companyProfileService,
                            CompanyProfileDAODatabase companyProfileDAO) {
        this.companyProfileDAO = companyProfileDAO;
        this.companyProfileService = companyProfileService;
        this.jsonSerialize = jsonSerialize;
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
