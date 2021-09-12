package com.example.anton_stock_feed.configuration;

import com.example.anton_stock_feed.dao.CompanyProfileDaoJpa;
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
    public CompanyProfileService companyProfileService(CompanyProfileDaoJpa companyProfileDaoJpa,
                                                       CompanyMapper companyMapper) {
        return new CompanyProfileServiceImpl(companyProfileDaoJpa, companyMapper);
    }

    @Bean
    public APIService apiService(CompanyProfileDaoJpa companyProfileDaoJpa,
                                 CompanyMapper companyMapper) {
        return new APIServiceFactory().createAPIService(apiServiceType,
                companyProfileService(companyProfileDaoJpa, companyMapper),
                jsonSerialize());
    }
}
