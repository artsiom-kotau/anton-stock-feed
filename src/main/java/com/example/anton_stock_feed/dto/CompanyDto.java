package com.example.anton_stock_feed.dto;

import com.example.anton_stock_feed.info.CompanyInfo;
import com.example.anton_stock_feed.info.ReportInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CompanyDto {

        private String currency;
        private String description;
        private String displaySymbol;
        private String figi;
        private String mic;
        private String symbol;
        private String type;
        private Integer id;
        private ReportInfo reportInfo;
}
