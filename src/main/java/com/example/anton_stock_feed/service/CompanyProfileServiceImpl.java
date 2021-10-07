package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dao.CompanyProfileDao;
import com.example.anton_stock_feed.dto.CompanyDto;
import com.example.anton_stock_feed.entity.CompanyEntity;
import com.example.anton_stock_feed.mappers.CompanyMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

public class CompanyProfileServiceImpl implements CompanyProfileService {
    CompanyProfileDao companyProfileDao;
    CompanyMapper companyMapper;

    public CompanyProfileServiceImpl(CompanyProfileDao companyProfileDao,
                                     CompanyMapper companyMapper) {
        this.companyProfileDao = companyProfileDao;
        this.companyMapper = companyMapper;
    }

    @Transactional
    @Override
    public CompanyDto findById(Integer id) {
        Optional<CompanyEntity> company = companyProfileDao.findById(id);
        return company.map(companyMapper::toDto).orElse(null);
    }

    @Transactional
    @Override
    public CompanyDto findByDisplaySymbol(String displaySymbol) {
        Optional<CompanyEntity> company = companyProfileDao.findAllByDisplaySymbol(displaySymbol);
        return company.map(companyMapper::toDto).orElse(null);
    }

    @Transactional
    @Override
    public Iterable<CompanyDto> findAll() {
        Iterable<CompanyEntity> companies = companyProfileDao.findAll();
        return companyMapper.companiesToCompanyDtos(companies);
    }

    @Transactional
    public Iterable<CompanyEntity> findAllEntities() {
        return companyProfileDao.findAll();
    }

    @Transactional
    @Override
    public void writeData(Iterable<CompanyDto> apiCompanies) {
        ArrayList<CompanyEntity> databaseCompanies;
        Map<String, CompanyEntity> databaseCompaniesMap = new HashMap<>();
        Map<String, CompanyEntity> updateCompaniesMap = new HashMap<>();
        Map<String, CompanyEntity> insertCompaniesMap = new HashMap<>();
        Map<String, CompanyEntity> insertUpdateCompaniesMap = new HashMap<>();

        databaseCompanies = (ArrayList<CompanyEntity>) findAllEntities();

        for (CompanyEntity companyEntity : databaseCompanies) {
            databaseCompaniesMap.put(companyEntity.getSymbol(), companyEntity);
        }

        for (CompanyDto companyDto : apiCompanies) {
            String companySymbol = companyDto.getSymbol();
            if (databaseCompaniesMap.containsKey(companySymbol)) {
                updateCompaniesMap.put(companySymbol, companyMapper.toEntity(companyDto));
                insertUpdateCompaniesMap.put(companySymbol, companyMapper.toEntity(companyDto));
            } else {
                insertCompaniesMap.put(companySymbol, companyMapper.toEntity(companyDto));
                insertUpdateCompaniesMap.put(companySymbol, companyMapper.toEntity(companyDto));
            }
        }

        for (String companySymbol : insertUpdateCompaniesMap.keySet()) {
            databaseCompaniesMap.remove(companySymbol);
        }

        for (Map.Entry<String, CompanyEntity> entry : updateCompaniesMap.entrySet()) {
            String companySymbol = entry.getKey();
            CompanyEntity companyEntityUpdated = entry.getValue();
            CompanyEntity companyEntityExisting = databaseCompanies.stream().filter(
                    companyEntity -> companySymbol.equals(companyEntity.getSymbol())).findFirst().orElse(null);
            int companyIndex = databaseCompanies.indexOf(companyEntityExisting);
            companyEntityUpdated.setId(companyEntityExisting.getId());
            databaseCompanies.set(companyIndex, companyEntityUpdated);
        }
        databaseCompanies.addAll(insertCompaniesMap.values());

        companyProfileDao.saveAll(databaseCompanies);
        companyProfileDao.deleteAll(databaseCompaniesMap.values());
    }

    @Transactional
    @Override
    public void save(Iterable<CompanyEntity> companies) {
        companyProfileDao.saveAll(companies);
    }

    @Transactional
    public Collection<String> findAllByDisplaySymbol() {
        return companyProfileDao.getAllSymbols();
    }
}
