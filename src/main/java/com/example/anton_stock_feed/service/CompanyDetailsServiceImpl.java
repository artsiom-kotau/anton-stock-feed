package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dao.CompanyDetailsDao;
import com.example.anton_stock_feed.dto.CompanyWithCreateCompanyDetailsRequestDto;
import com.example.anton_stock_feed.dto.CompanyDetailsDto;
import com.example.anton_stock_feed.dto.CreateCompanyDetailsRequestDto;
import com.example.anton_stock_feed.entity.CompanyDetailsEntity;
import com.example.anton_stock_feed.mappers.CompanyDetailsMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

public class CompanyDetailsServiceImpl implements CompanyDetailsService {
    CompanyDetailsDao companyDetailsDao;
    CompanyDetailsMapper companyDetailsMapper;
    CompanyProfileService companyProfileService;

    public CompanyDetailsServiceImpl(CompanyDetailsDao companyDetailsDao,
                                     CompanyDetailsMapper companyDetailsMapper,
                                     CompanyProfileService companyProfileService) {
        this.companyDetailsDao = companyDetailsDao;
        this.companyDetailsMapper = companyDetailsMapper;
        this.companyProfileService = companyProfileService;
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<CompanyDetailsDto> findBySymbol(String symbol) {
        Collection<CompanyDetailsEntity> companyDetailsEntities =
                companyDetailsDao.findCompanyDetailsEntitiesBySymbol(symbol);
        Iterable<CompanyDetailsDto> companyDetailsDtos =
                companyDetailsMapper.companyDetailsToCompanyDetailsDtos(companyDetailsEntities);
        return companyDetailsDtos;
    }

    @Override
    public Iterable<CreateCompanyDetailsRequestDto> findCreateCompanyDetailsRequestDtosBySymbol(String symbol) {
        return null;
    }

    @Transactional
    @Override
    public Iterable<CompanyDetailsDto> addCompanyDetails(CompanyDetailsDto companyDetailsDto,
                                                         String symbol) {
        Iterable<CompanyWithCreateCompanyDetailsRequestDto> companyCreateCompanyDetailsRequestDtos =
                companyProfileService.findCompanyWithCreateCompanyDetailsRequestDtosByDisplaySymbol(symbol);
        return null;
    }

    @Transactional
    @Override
    public void addCompanyDetailsToOneEntity(CreateCompanyDetailsRequestDto createCompanyDetailsRequestDto,
                                             String symbol) {
        CompanyWithCreateCompanyDetailsRequestDto companyWithCreateCompanyDetailsRequestDto =
                companyProfileService.findCompanyWithCreateCompanyDetailsRequestDtoByDisplaySymbol(symbol);
        List<CreateCompanyDetailsRequestDto> createCompanyDetailsRequestDtos =
                companyWithCreateCompanyDetailsRequestDto.getCompanyDetails();
        createCompanyDetailsRequestDtos.add(createCompanyDetailsRequestDto);
        companyWithCreateCompanyDetailsRequestDto.setCompanyDetails(createCompanyDetailsRequestDtos);
        companyProfileService.saveCompanyWithCreateCompanyDetailsRequestDto(companyWithCreateCompanyDetailsRequestDto);
    }
}