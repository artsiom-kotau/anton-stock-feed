package com.example.anton_stock_feed.entity;

import javax.persistence.*;

@Entity
@Table(name = "company_profile")
public class CompanyEntity {
    private String currency;
    private String description;

    @Column(name = "displaysymbol")
    private String displaySymbol;
    private String figi;
    private String mic;
    private String symbol;
    private String type;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public CompanyEntity(String currency,
                         String description,
                         String displaySymbol,
                         String figi,
                         String mic,
                         String symbol,
                         String type) {

        this.currency = currency;
        this.description = description;
        this.displaySymbol = displaySymbol;
        this.figi = figi;
        this.mic = mic;
        this.symbol = symbol;
        this.type = type;
    }

    public CompanyEntity() {

    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDisplaySymbol(String displaySymbol) {
        this.displaySymbol = displaySymbol;
    }

    public void setFigi(String figi) {
        this.figi = figi;
    }

    public void setMic(String mic) {
        this.mic = mic;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCurrency() {
        return currency;
    }

    public String getDescription() {
        return description;
    }

    public String getDisplaySymbol() {
        return displaySymbol;
    }

    public String getFigi() {
        return figi;
    }

    public String getMic() {
        return mic;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Company{" +
                "currency='" + currency + '\'' +
                ", description='" + description + '\'' +
                ", displaysymbol='" + displaySymbol + '\'' +
                ", figi='" + figi + '\'' +
                ", mic='" + mic + '\'' +
                ", symbol='" + symbol + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @GeneratedValue
    public Integer getId() {
        return id;
    }
}
