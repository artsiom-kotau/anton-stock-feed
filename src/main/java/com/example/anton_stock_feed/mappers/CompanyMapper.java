package com.example.anton_stock_feed.mappers;

import com.example.anton_stock_feed.dto.CompanyWithCreateCompanyDetailsRequestDto;
import com.example.anton_stock_feed.dto.CompanyDto;
import com.example.anton_stock_feed.dto.CreateCompanyDetailsRequestDto;
import com.example.anton_stock_feed.entity.CompanyDetailsEntity;
import com.example.anton_stock_feed.entity.CompanyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyDto toDto(CompanyEntity companyEntity);

    Iterable<CompanyDto> companiesToCompanyDtos(Iterable<CompanyEntity> companies);

    CompanyEntity toEntity(CompanyDto companyDto);

    Iterable<CompanyEntity> dtosToCompanyEntities(Iterable<CompanyDto> companyDtos);


    CompanyWithCreateCompanyDetailsRequestDto toCompanyWithCreateCompanyDetailsRequestDto(CompanyEntity companyEntity);

    Iterable<CompanyWithCreateCompanyDetailsRequestDto> companiesToCompanyWithCreateCompanyDetailsRequestDtos(
            Iterable<CompanyEntity> companies);

    CompanyEntity toEntity(CompanyWithCreateCompanyDetailsRequestDto companyWithCreateCompanyDetailsRequestDto);

    Iterable<CompanyEntity> CompanyWithCreateCompanyDetailsRequestDtosToCompanyEntities(
            Iterable<CompanyWithCreateCompanyDetailsRequestDto> companyCreateCompanyDetailsRequestDtos);


    CreateCompanyDetailsRequestDto toCreateCompanyDetailsRequestDto(CompanyDetailsEntity companyDetailsEntity);

    Iterable<CreateCompanyDetailsRequestDto> companyDetailsToCreateCompanyDetailsRequestDtos(
            Iterable<CompanyDetailsEntity> companyDetailsEntities);

    CompanyDetailsEntity toEntity(CreateCompanyDetailsRequestDto createCompanyDetailsRequestDto);

    Iterable<CompanyDetailsEntity> createCompanyDetailsRequestDtosToCompanyDetails(
            Iterable<CreateCompanyDetailsRequestDto> createCompanyDetailsRequestDtos);
}
