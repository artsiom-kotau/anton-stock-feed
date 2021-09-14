package com.example.anton_stock_feed.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "displaysymbol")
    private CompanyEntity companyEntity;

    public ReportEntity(String cik,
                        String accessNumber,
                        String year,
                        String quarter,
                        String form,
                        String startDate,
                        String endDate,
                        String filedDate,
                        String acceptedDate,
                        String report,
                        String symbol) {
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

    public ReportEntity() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCik() {
        return cik;
    }

    public void setCik(String cik) {
        this.cik = cik;
    }

    public String getAccessNumber() {
        return accessNumber;
    }

    public void setAccessNumber(String accessNumber) {
        this.accessNumber = accessNumber;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getFiledDate() {
        return filedDate;
    }

    public void setFiledDate(String filedDate) {
        this.filedDate = filedDate;
    }

    public String getAcceptedDate() {
        return acceptedDate;
    }

    public void setAcceptedDate(String acceptedDate) {
        this.acceptedDate = acceptedDate;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "ReportEntity{" +
                "id=" + id +
                ", cik='" + cik + '\'' +
                ", accessNumber='" + accessNumber + '\'' +
                ", year='" + year + '\'' +
                ", quarter='" + quarter + '\'' +
                ", form='" + form + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", filedDate='" + filedDate + '\'' +
                ", acceptedDate='" + acceptedDate + '\'' +
                ", report='" + report + '\'' +
                ", symbol='" + symbol + '\'' +
                ", companyEntity=" + companyEntity +
                '}';
    }
}
