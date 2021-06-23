package com.example.anton_stock_feed.model;

public class CompanyClass {
    private String currency;
    private String description;
    private String displaysymbol;
    private String figi;
    private String mic;
    private String symbol;
    private String type;

    public CompanyClass (String currency,
            String description,
            String displaysymbol,
            String figi,
            String mic,
            String symbol,
            String type) {

        this.currency = currency;
        this.description = description;
        this.displaysymbol = displaysymbol;
        this.figi = figi;
        this.mic = mic;
        this.symbol = symbol;
        this.type = type;
    }

    public String getCurrency() {
        return currency;
    }

    public String getDescription() {
        return description;
    }

    public String getDisplaysymbol() {
        return displaysymbol;
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
}
