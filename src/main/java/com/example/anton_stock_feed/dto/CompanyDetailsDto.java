package com.example.anton_stock_feed.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
public class CompanyDetailsDto {

    private Integer id;
    private String country;
    private String exchange;
    private String finnhubIndustry;
    private String ipo;
    private String logo;
    private String marketCapitalization;
    private String name;
    private String phone;
    private String shareOutstanding;
    private String symbol;
    private String webUrl;

    private Collection<CompanyDto> companyProfile;

}
