package com.example.anton_stock_feed.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company_profile")
public class CompanyEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String currency;
    private String description;

    @Column(name = "displaysymbol")
    @NaturalId
    private String displaySymbol;

    private String figi;
    private String mic;
    private String symbol;
    private String type;

    @JsonIgnoreProperties("companyEntity")
    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "companyEntity")
    private List<ReportEntity> reports;
}