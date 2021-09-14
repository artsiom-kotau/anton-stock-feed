package com.example.anton_stock_feed.dao;

import com.example.anton_stock_feed.entity.ReportEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ReportDao extends CrudRepository<ReportEntity, Integer> {

    Collection<ReportEntity> findReportEntitiesBySymbol(String symbol);
}
