package com.example.anton_stock_feed.dao;

import com.example.anton_stock_feed.entity.CompanyDetailsCompanyEntity;
import org.springframework.data.repository.CrudRepository;

public interface CompanyDetailsCompanyDao extends CrudRepository<CompanyDetailsCompanyEntity, Integer> {
}
