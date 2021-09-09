package com.example.anton_stock_feed.dao;

import com.example.anton_stock_feed.entity.CompanyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CompanyProfileDaoJpa extends CrudRepository<CompanyEntity, Integer> {

    Optional<CompanyEntity> findAllByDisplaySymbol(String displaySymbol);

    @Query(value = "SELECT symbol FROM company_profile", nativeQuery = true)
    Iterable<String> getAllSymbols();
}
