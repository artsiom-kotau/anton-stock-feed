package com.example.anton_stock_feed.configuration;

import com.example.anton_stock_feed.dao.CompanyProfileDao;
import com.example.anton_stock_feed.dao.ReportDao;
import com.example.anton_stock_feed.service.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan({"com"})
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
    public APIService apiService(CompanyProfileDao companyProfileDao,
                                 CompanyMapper companyMapper) {
        return new APIServiceFactory().createAPIService(apiServiceType,
                companyProfileService(companyProfileDao, companyMapper),
                jsonSerialize());
    }
}
