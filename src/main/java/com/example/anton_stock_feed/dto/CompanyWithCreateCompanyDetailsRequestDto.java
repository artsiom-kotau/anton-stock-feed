package com.example.anton_stock_feed.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class CompanyWithCreateCompanyDetailsRequestDto {

    private String currency;
    private String description;
    private String displaySymbol;
    private String figi;
    private String mic;
    private String symbol;
    private String type;
    private Integer id;
    private Set<CreateCompanyDetailsRequestDto> companyDetails;

}
