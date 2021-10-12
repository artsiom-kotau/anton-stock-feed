package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dao.CompanyDetailsDao;
import com.example.anton_stock_feed.dto.CompanyCreateCompanyDetailsRequestDto;
import com.example.anton_stock_feed.dto.CompanyDetailsDto;
import com.example.anton_stock_feed.entity.CompanyDetailsEntity;
import com.example.anton_stock_feed.mappers.CompanyDetailsMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

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
        Collection<CompanyDetailsEntity> companyDetailsEntities = companyDetailsDao.findCompanyDetailsEntitiesBySymbol(symbol);
        Iterable<CompanyDetailsDto> companyDetailsDtos = companyDetailsMapper.cdToCdDtos(companyDetailsEntities);
        return companyDetailsDtos;
    }

    @Transactional
    @Override
    public Iterable<CompanyDetailsDto> addCompanyDetails(CompanyDetailsDto companyDetailsDto,
                                                         String symbol) {
        Iterable<CompanyCreateCompanyDetailsRequestDto> companyCreateCompanyDetailsRequestDtos =
                companyProfileService.findCCCDRDtosByDisplaySymbol(symbol);
        return null;
    }

    @Transactional
    @Override
    public CompanyDetailsDto addCompanyDetailsToOneEntity(CompanyDetailsDto companyDetailsDto, String symbol) {
        return null;
    }
}
