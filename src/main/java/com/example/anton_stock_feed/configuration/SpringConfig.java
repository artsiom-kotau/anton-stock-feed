package com.example.anton_stock_feed.configuration;

import com.example.anton_stock_feed.dao.BasicFinancialsDao;
import com.example.anton_stock_feed.dao.CompanyDetailsDao;
import com.example.anton_stock_feed.dao.CompanyProfileDao;
import com.example.anton_stock_feed.dao.ReportDao;
import com.example.anton_stock_feed.mappers.BasicFinancialsMapper;
import com.example.anton_stock_feed.mappers.CompanyDetailsMapper;
import com.example.anton_stock_feed.mappers.CompanyMapper;
import com.example.anton_stock_feed.mappers.ReportMapper;
import com.example.anton_stock_feed.service.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Value("${APIService}")
    String apiServiceType;

    @Bean
    public JsonSerialize jsonSerialize() {
        return new JsonSerializeFactory().createJsonSerialize("Gson");
    }

    @Bean
    public CompanyProfileService companyProfileService(CompanyProfileDao companyProfileDao,
                                                       CompanyMapper companyMapper) {
        return new CompanyProfileServiceImpl(companyProfileDao, companyMapper);
    }

    @Bean
    public ReportService reportService(ReportDao reportDao,
                                       ReportMapper reportMapper) {
        return new ReportServiceImpl(reportDao, reportMapper);
    }

    @Bean
    public BasicFinancialsService basicFinancialsService(BasicFinancialsDao basicFinancialsDao,
                                                         BasicFinancialsMapper basicFinancialsMapper) {
        return new BasicFinancialsServiceImpl(basicFinancialsDao, basicFinancialsMapper);
    }

    @Bean
    public CompanyDetailsService companyDetailsService(CompanyDetailsDao companyDetailsDao,
                                                       CompanyDetailsMapper companyDetailsMapper) {
        return new CompanyDetailsServiceImpl(companyDetailsDao, companyDetailsMapper);
    }

    @Bean
    public APIService apiService(CompanyProfileDao companyProfileDao,
                                 CompanyMapper companyMapper) {
        return new APIServiceFactory().createAPIService(apiServiceType,
                companyProfileService(companyProfileDao, companyMapper),
                jsonSerialize());
    }
}
