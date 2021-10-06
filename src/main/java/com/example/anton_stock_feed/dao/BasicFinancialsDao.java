package com.example.anton_stock_feed.dao;

import com.example.anton_stock_feed.entity.BasicFinancialsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BasicFinancialsDao extends CrudRepository<BasicFinancialsEntity, Integer> {

    Optional<BasicFinancialsEntity> findAllBySymbol(String symbol);
}
