package com.example.anton_stock_feed.mappers;

import com.example.anton_stock_feed.dto.CompanyDetailsDto;
import com.example.anton_stock_feed.dto.CompanyDto;
import com.example.anton_stock_feed.dto.CreateCompanyDetailsRequestDto;
import com.example.anton_stock_feed.entity.CompanyDetailsEntity;
import com.example.anton_stock_feed.entity.CompanyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyDetailsMapper {

    CompanyDetailsDto toDto(CompanyDetailsEntity companyDetailsEntity);

    Iterable<CompanyDetailsDto> companyDetailsToCompanyDetailsDtos(Iterable<CompanyDetailsEntity> companyDetailsEntities);

    CompanyDetailsEntity toEntity(CompanyDetailsDto companyDetailsDto);

    Iterable<CompanyDetailsEntity> dtosToCompanyEntities(Iterable<CompanyDetailsDto> cdDtos);


    CompanyDto toCompanyProfileDto(CompanyEntity companyEntity);

    Iterable<CompanyDto> companiesToCompanyProfileDtos(Iterable<CompanyEntity> companies);

    CompanyEntity toCompanyProfileEntity(CompanyDto companyDto);

    Iterable<CompanyEntity> companyDtosToCompanyProfileEntities(Iterable<CompanyDto> companyDtos);


    CreateCompanyDetailsRequestDto toCreateCompanyDetailsRequestDto(CompanyDetailsEntity companyDetailsEntity);

    Iterable<CreateCompanyDetailsRequestDto> companyDetailsToCreateCompanyDetailsRequestDtos(
            Iterable<CompanyDetailsEntity> companyDetailsEntities);

    CompanyDetailsEntity toEntity(CreateCompanyDetailsRequestDto createCompanyDetailsRequestDto);

    Iterable<CompanyDetailsEntity> createCompanyDetailsRequestDtosToCompanyDetails(
            Iterable<CreateCompanyDetailsRequestDto> createCompanyDetailsRequestDtos);
}