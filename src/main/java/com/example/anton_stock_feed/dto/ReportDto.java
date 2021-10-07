package com.example.anton_stock_feed.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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

    public ReportDto(String cik, String accessNumber, String year, String quarter, String form, String startDate, String endDate, String filedDate, String acceptedDate, String report, String symbol) {
        this.cik = cik;
        this.accessNumber = accessNumber;
        this.year = year;
        this.quarter = quarter;
        this.form = form;
        this.startDate = startDate;
        this.endDate = endDate;
        this.filedDate = filedDate;
        this.acceptedDate = acceptedDate;
        this.report = report;
        this.symbol = symbol;
    }
}