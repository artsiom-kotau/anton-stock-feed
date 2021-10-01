package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dto.ReportDto;
import com.example.anton_stock_feed.entity.ReportEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface ReportMapper {

    ReportDto toDto(ReportEntity reportEntity);

    Iterable<ReportDto> reportsToReportDtos(Iterable<ReportEntity> reports);

    ReportEntity toEntity(ReportDto reportDto);

    Iterable<ReportEntity> dtosToReportEntities(Iterable<ReportDto> reportDtos);
}
