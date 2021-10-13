package com.example.anton_stock_feed.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCompanyDetailsRequestDto {

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

    public CreateCompanyDetailsRequestDto(String country, String exchange, String finnhubIndustry, String ipo, String logo, String marketCapitalization, String name, String phone, String shareOutstanding, String symbol, String webUrl) {
        this.country = country;
        this.exchange = exchange;
        this.finnhubIndustry = finnhubIndustry;
        this.ipo = ipo;
        this.logo = logo;
        this.marketCapitalization = marketCapitalization;
        this.name = name;
        this.phone = phone;
        this.shareOutstanding = shareOutstanding;
        this.symbol = symbol;
        this.webUrl = webUrl;
    }
}
