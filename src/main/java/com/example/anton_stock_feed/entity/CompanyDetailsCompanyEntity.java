package com.example.anton_stock_feed.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "company_details_company")
public class CompanyDetailsCompanyEntity {

    @Column(name = "company_id")
    Integer companyId;
    @Column(name = "company_details_id")
    Integer companyDetailsId;
}
