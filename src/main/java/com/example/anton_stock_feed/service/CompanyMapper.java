package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dto.CompanyDto;
import com.example.anton_stock_feed.entity.CompanyEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CompanyMapper {

    CompanyDto toDto(Optional<CompanyEntity> companyEntity);

    Iterable<CompanyDto> companiesToCompanyDtos(Iterable<CompanyEntity> companies);
}
