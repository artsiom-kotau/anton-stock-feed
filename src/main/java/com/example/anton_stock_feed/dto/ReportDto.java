package com.example.anton_stock_feed.dto;

import com.example.anton_stock_feed.entity.CompanyEntity;
import com.example.anton_stock_feed.info.CompanyInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReportDto {

    private Integer id;
    private String cik;
    private String accessNumber;
    private String year;
    private String quarter;
    private String form;
    private String startDate;
    private String endDate;
    private String filedDate;
    private String acceptedDate;
    private String report;
    private String symbol;
    private CompanyInfo companyInfo;
}
