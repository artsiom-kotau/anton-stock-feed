package com.example.anton_stock_feed.dao;

import com.example.anton_stock_feed.entity.CompanyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface CompanyProfileDao extends CrudRepository<CompanyEntity, Integer> {

    Optional<CompanyEntity> findByDisplaySymbol(String displaySymbol);

    Iterable<CompanyEntity> findAllByDisplaySymbol(String displaySymbol);

    @Query(value = "SELECT symbol FROM company_profile", nativeQuery = true)
    Collection<String> getAllSymbols();

}