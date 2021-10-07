package com.example.anton_stock_feed.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "financials_as_reported")
public class ReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cik;
    @Column(name = "accessnumber")
    private String accessNumber;
    private String year;
    private String quarter;
    private String form;
    @Column(name = "startdate")
    private String startDate;
    @Column(name = "enddate")
    private String endDate;
    @Column(name = "fileddate")
    private String filedDate;
    @Column(name = "accepteddate")
    private String acceptedDate;
    private String report;
    private String symbol;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "symbol",
            referencedColumnName = "displaySymbol",
            insertable = false,
            updatable = false
    )
    private CompanyEntity company;

    public ReportEntity(String cik, String accessNumber, String year, String quarter, String form, String startDate, String endDate, String filedDate, String acceptedDate, String report, String symbol) {
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