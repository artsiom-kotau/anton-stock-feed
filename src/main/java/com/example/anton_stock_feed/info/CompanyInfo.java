package com.example.anton_stock_feed.info;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CompanyInfo {

        private String currency;
        private String description;
        private String displaySymbol;
        private String figi;
        private String mic;
        private String symbol;
        private String type;
        private Integer id;
}
