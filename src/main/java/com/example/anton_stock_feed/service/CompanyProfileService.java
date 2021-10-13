package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dto.CompanyWithCreateCompanyDetailsRequestDto;
import com.example.anton_stock_feed.dto.CompanyDto;
import com.example.anton_stock_feed.entity.CompanyEntity;

public interface CompanyProfileService {

    CompanyDto findById(Integer id);

    CompanyDto findByDisplaySymbol(String displaySymbol);

    Iterable<CompanyWithCreateCompanyDetailsRequestDto> findCompanyWithCreateCompanyDetailsRequestDtosByDisplaySymbol(
            String displaySymbol);

    CompanyWithCreateCompanyDetailsRequestDto findCompanyWithCreateCompanyDetailsRequestDtoByDisplaySymbol(
            String displaySymbol);

    CompanyEntity findCompanyEntityByDisplaySymbol(String displaySymbol);

    Iterable<CompanyDto> findAll();

    void saveAll(Iterable<CompanyEntity> companies);

    void writeData(Iterable<CompanyDto> apiCompanies);

    <S extends CompanyEntity> S save(S entity);

    CompanyWithCreateCompanyDetailsRequestDto saveCompanyWithCreateCompanyDetailsRequestDto(
            CompanyWithCreateCompanyDetailsRequestDto companyWithCreateCompanyDetailsRequestDto);
}
