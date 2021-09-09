package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dao.CompanyProfileDaoJpa;
import com.example.anton_stock_feed.dto.CompanyDto;
import com.example.anton_stock_feed.entity.CompanyEntity;

import javax.transaction.Transactional;
import java.util.*;

public class CompanyProfileServiceJpaImpl implements CompanyProfileServiceJpa {

    CompanyProfileDaoJpa companyProfileDaoJpa;
    CompanyMapper companyMapper;

    public CompanyProfileServiceJpaImpl(CompanyProfileDaoJpa companyProfileDaoJpa) {
        this.companyProfileDaoJpa = companyProfileDaoJpa;
    }

    @Transactional
    @Override
    public CompanyDto findById(Integer id) {
        Optional<CompanyEntity> company = companyProfileDaoJpa.findById(id);
        return companyMapper.toDto(company);
    }

    @Transactional
    @Override
    public CompanyDto findByDisplaySymbol(String displaySymbol) {
        Optional<CompanyEntity> company = companyProfileDaoJpa.findAllByDisplaySymbol(displaySymbol);
        return companyMapper.toDto(company);
    }

    @Transactional
    @Override
    public Iterable<CompanyDto> findAll() {
        Iterable<CompanyEntity> companies = companyProfileDaoJpa.findAll();
        return companyMapper.companiesToCompanyDtos(companies);
    }

    @Transactional
    @Override
    public void save(Iterable<CompanyEntity> companies) {
        companyProfileDaoJpa.saveAll(companies);
    }

    @Transactional
    public Iterable<String> findAllByDisplaySymbol() {
        return companyProfileDaoJpa.getAllSymbols();
    }
}
