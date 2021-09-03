package com.example.anton_stock_feed.configuration;

import com.example.anton_stock_feed.dao.CompanyProfileDAO;
import com.example.anton_stock_feed.dao.CompanyProfileDAOFactory;
import com.example.anton_stock_feed.service.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Value("${DAO}")
    String daoType;

    @Value("${APIService}")
    String apiServiceType;

    @Bean
    public CompanyProfileDAO companyProfileDAO() {
        return new CompanyProfileDAOFactory().createCompanyProfileDAO(daoType);
    }

    @Bean
    public JsonSerialize jsonSerialize() {
        return new JsonSerializeFactory().createJsonSerialize("Gson");
    }

    @Bean
    public APIService apiService() {
        return new APIServiceFactory().createAPIService(apiServiceType, companyProfileService(), jsonSerialize());
    }

    @Bean
    public CompanyProfileServiceInterface companyProfileService() {
        return new CompanyProfileService(companyProfileDAO());
    }
}
