package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dto.ReportDto;
import com.example.anton_stock_feed.entity.ReportEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReportMapper {

    ReportDto toDto(ReportEntity reportEntity);

    Iterable<ReportDto> companiesToCompanyDtos(Iterable<ReportEntity> companies);

    ReportEntity toEntity(ReportDto reportDto);

    Iterable<ReportEntity> dtosToReportEntities(Iterable<ReportDto> reportDtos);
}
