package com.example.anton_stock_feed.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "financials_as_reported")
public class ReportEntityTemp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cik;
    private List<String> data;
    private String symbol;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "displaysymbol")
    private CompanyEntity companyEntity;

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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public CompanyEntity getCompanyEntity() {
        return companyEntity;
    }

    public void setCompanyEntity(CompanyEntity companyEntity) {
        this.companyEntity = companyEntity;
    }

    public ReportEntityTemp() {
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public ReportEntityTemp(Integer id, String cik, List<String> data, String symbol, CompanyEntity companyEntity) {
        this.id = id;
        this.cik = cik;
        this.data = data;
        this.symbol = symbol;
        this.companyEntity = companyEntity;
    }

    @Override
    public String toString() {
        return "ReportEntityTemp{" +
                "id=" + id +
                ", cik='" + cik + '\'' +
                ", data='" + data + '\'' +
                ", symbol='" + symbol + '\'' +
                ", companyEntity=" + companyEntity +
                '}';
    }
}
