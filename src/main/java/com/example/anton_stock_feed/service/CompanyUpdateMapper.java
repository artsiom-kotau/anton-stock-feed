package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.entity.CompanyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface CompanyUpdateMapper {
    void updateCompany(CompanyEntity sourceCompanyEntity, @MappingTarget CompanyEntity targetCompanyEntity);
}