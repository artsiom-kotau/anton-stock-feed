package com.example.anton_stock_feed.dao;

import com.example.anton_stock_feed.entity.CompanyDetailsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public interface CompanyDetailsDao extends CrudRepository<CompanyDetailsEntity, Integer> {

    Collection<CompanyDetailsEntity> findCompanyDetailsEntitiesBySymbol(String symbol);
}
