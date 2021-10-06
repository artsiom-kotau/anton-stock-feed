package com.example.anton_stock_feed.mappers;

import com.example.anton_stock_feed.dto.CompanyDto;
import com.example.anton_stock_feed.entity.CompanyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyDto toDto(CompanyEntity companyEntity);

    Iterable<CompanyDto> companiesToCompanyDtos(Iterable<CompanyEntity> companies);

    CompanyEntity toEntity(CompanyDto companyDto);

    Iterable<CompanyEntity> dtosToCompanyEntities(Iterable<CompanyDto> companyDtos);
}
