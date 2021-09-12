package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.dao.CompanyProfileDaoJpa;
import com.example.anton_stock_feed.dto.CompanyDto;
import com.example.anton_stock_feed.entity.CompanyEntity;

import javax.transaction.Transactional;
import java.util.*;

public class CompanyProfileServiceImpl implements CompanyProfileService {
    CompanyProfileDaoJpa companyProfileDaoJpa;
    CompanyMapper companyMapper;

    public CompanyProfileServiceImpl(CompanyProfileDaoJpa companyProfileDaoJpa,
                                     CompanyMapper companyMapper) {
        this.companyProfileDaoJpa = companyProfileDaoJpa;
        this.companyMapper = companyMapper;
    }

    @Transactional
    @Override
    public CompanyDto findById(Integer id) {
        Optional<CompanyEntity> company = companyProfileDaoJpa.findById(id);
        return company.map(companyMapper::toDto).orElse(null);
    }

    @Transactional
    @Override
    public CompanyDto findByDisplaySymbol(String displaySymbol) {
        Optional<CompanyEntity> company = companyProfileDaoJpa.findAllByDisplaySymbol(displaySymbol);
        return company.map(companyMapper::toDto).orElse(null);
    }

    @Transactional
    @Override
    public Iterable<CompanyDto> findAll() {
        Iterable<CompanyEntity> companies = companyProfileDaoJpa.findAll();
        return companyMapper.companiesToCompanyDtos(companies);
    }

    @Transactional
    public Iterable<CompanyEntity> findAllEntities() {
        return companyProfileDaoJpa.findAll();
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
            }
            else {
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

        companyProfileDaoJpa.saveAll(databaseCompanies);
        companyProfileDaoJpa.deleteAll(databaseCompaniesMap.values());
    }

    @Transactional
    @Override
    public void save(Iterable<CompanyEntity> companies) {
        companyProfileDaoJpa.saveAll(companies);
    }

    @Transactional
    public Collection<String> findAllByDisplaySymbol() {
        return companyProfileDaoJpa.getAllSymbols();
    }
}
