package com.example.anton_stock_feed.mappers;

import com.example.anton_stock_feed.dto.BasicFinancialsDto;
import com.example.anton_stock_feed.entity.BasicFinancialsEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BasicFinancialsMapper {

    BasicFinancialsDto toDto(BasicFinancialsEntity basicFinancialsEntity);

    Iterable<BasicFinancialsDto> financialsToFinancialsDtos(Iterable<BasicFinancialsEntity> financialsEntities);

    BasicFinancialsEntity toEntity(BasicFinancialsDto basicFinancialsDto);

    Iterable<BasicFinancialsEntity> dtosToFinancialsEntities(Iterable<BasicFinancialsDto> financialsDtos);
}
