package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dto.CompanyDto;
import com.example.anton_stock_feed.entity.CompanyEntity;
import com.example.anton_stock_feed.info.CompanyInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyDto toDto(CompanyEntity companyEntity);

    Iterable<CompanyDto> companiesToCompanyDtos(Iterable<CompanyEntity> companies);

    CompanyEntity toEntity(CompanyDto companyDto);

    Iterable<CompanyEntity> dtosToCompanyEntities(Iterable<CompanyDto> companyDtos);


    CompanyInfo toInfoDto(CompanyEntity companyEntity);

    Iterable<CompanyInfo> companiesToCompanyInfoDtos(Iterable<CompanyEntity> companies);

    CompanyEntity toEntity(CompanyInfo companyInfo);

    Iterable<CompanyEntity> infoDtosToCompanyEntities(Iterable<CompanyInfo> companyInfoDtos);
}
