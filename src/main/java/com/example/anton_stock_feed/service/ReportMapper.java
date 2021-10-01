package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dto.ReportDto;
import com.example.anton_stock_feed.entity.CompanyEntity;
import com.example.anton_stock_feed.entity.ReportEntity;
import com.example.anton_stock_feed.info.CompanyInfo;
import com.example.anton_stock_feed.info.ReportInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface ReportMapper {

    ReportDto toDto(ReportEntity reportEntity);

    @Mapping(source = "reports.reportEntity.companyEntity", target = "ReportDto.companyInfo")
    Iterable<ReportDto> reportsToReportDtos(Iterable<ReportEntity> reports);

    CompanyInfo toInfo(CompanyEntity companyEntity);

    Iterable<CompanyInfo> companiesToCompanyInfoDtos(Iterable<CompanyEntity> companies);

    ReportEntity toEntity(ReportDto reportDto);

    Iterable<ReportEntity> dtosToReportEntities(Iterable<ReportDto> reportDtos);

    ReportInfo toInfoDto(ReportEntity reportEntity);

    Iterable<ReportInfo> reportsToReportInfoDtos(Iterable<ReportEntity> reports);

    ReportEntity toEntity(ReportInfo reportInfo);

    Iterable<ReportEntity> infoDtosToReportEntities(Iterable<ReportInfo> reportInfos);
}
