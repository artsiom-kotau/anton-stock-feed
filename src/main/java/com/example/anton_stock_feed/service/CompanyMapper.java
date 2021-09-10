package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dto.CompanyDto;
import com.example.anton_stock_feed.entity.CompanyEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Mapper
public interface CompanyMapper {

    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    CompanyDto toDto(Optional<CompanyEntity> companyEntity);

    Iterable<CompanyDto> companiesToCompanyDtos(Iterable<CompanyEntity> companies);
}
