package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dao.BasicFinancialsDao;
import com.example.anton_stock_feed.dto.BasicFinancialsDto;
import com.example.anton_stock_feed.entity.BasicFinancialsEntity;
import com.example.anton_stock_feed.mappers.BasicFinancialsMapper;

import javax.transaction.Transactional;
import java.util.Optional;

public class BasicFinancialsServiceImpl implements BasicFinancialsService{
    BasicFinancialsDao basicFinancialsDao;
    BasicFinancialsMapper basicFinancialsMapper;

    public BasicFinancialsServiceImpl(BasicFinancialsDao basicFinancialsDao,
                                      BasicFinancialsMapper basicFinancialsMapper) {
        this.basicFinancialsDao = basicFinancialsDao;
        this.basicFinancialsMapper = basicFinancialsMapper;
    }

    @Transactional
    @Override
    public BasicFinancialsDto findBySymbol(String symbol) {
        Optional<BasicFinancialsEntity> basicFinancialsEntity = basicFinancialsDao.findAllBySymbol(symbol);
        return basicFinancialsEntity.map(basicFinancialsMapper::toDto).orElse(null);
    }
}
