package com.example.anton_stock_feed.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "company_details")
public class CompanyDetailsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String country;
    private String exchange;

    @Column(name = "finnhub_industry")
    private String finnhubIndustry;
    private String ipo;
    private String logo;

    @Column(name = "market_capitalization")
    private String marketCapitalization;
    private String name;
    private String phone;

    @Column(name = "share_outstanding")
    private String shareOutstanding;

    @Column(name = "ticker")
    private String symbol;

    @Column(name = "web_url")
    private String webUrl;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "companyDetails")
    private Collection<CompanyEntity> companyProfile;
}
