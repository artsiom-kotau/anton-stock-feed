package com.example.anton_stock_feed.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BasicFinancialsDto {

    private Integer id;
    private String metric;
    private String metricType;
    private String series;
    private String symbol;

}
