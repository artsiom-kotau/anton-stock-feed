package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dto.CompanyDetailsDto;
import com.example.anton_stock_feed.dto.CreateCompanyDetailsRequestDto;

public interface CompanyDetailsService {

    Iterable<CompanyDetailsDto> findBySymbol(String symbol);

    Iterable<CreateCompanyDetailsRequestDto> findCreateCompanyDetailsRequestDtosBySymbol(String symbol);

    Iterable<CompanyDetailsDto> addCompanyDetails(CompanyDetailsDto companyDetailsDto, String symbol);

    void addCompanyDetailsToOneEntity(CreateCompanyDetailsRequestDto createCompanyDetailsRequestDto,
                                      String symbol);

    void deleteCompanyDetails(Integer id);

}
