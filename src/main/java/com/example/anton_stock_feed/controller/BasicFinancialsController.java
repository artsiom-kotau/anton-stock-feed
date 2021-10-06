package com.example.anton_stock_feed.controller;

import com.example.anton_stock_feed.dto.BasicFinancialsDto;
import com.example.anton_stock_feed.service.BasicFinancialsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/basicfinancials")
public class BasicFinancialsController {

    BasicFinancialsService basicFinancialsService;

    public BasicFinancialsController(BasicFinancialsService basicFinancialsService) {
        this.basicFinancialsService = basicFinancialsService;
    }

    @GetMapping("{companyName}")
    public BasicFinancialsDto getBasicFinancials(@PathVariable String companyName) {
        return basicFinancialsService.findBySymbol(companyName);
    }

}