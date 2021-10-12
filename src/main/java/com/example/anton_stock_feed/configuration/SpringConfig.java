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
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
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
                                       ReportMapper reportMapper,
                                       CompanyProfileService companyProfileService) {
        return new ReportServiceImpl(reportDao, reportMapper, companyProfileService);
    }

    @Bean
    public BasicFinancialsService basicFinancialsService(BasicFinancialsDao basicFinancialsDao,
                                                         BasicFinancialsMapper basicFinancialsMapper) {
        return new BasicFinancialsServiceImpl(basicFinancialsDao, basicFinancialsMapper);
    }

    @Bean
    public CompanyDetailsService companyDetailsService(CompanyDetailsDao companyDetailsDao,
                                                       CompanyDetailsMapper companyDetailsMapper,
                                                       CompanyProfileService companyProfileService) {
        return new CompanyDetailsServiceImpl(companyDetailsDao, companyDetailsMapper, companyProfileService);
    }

    @Bean
    public APIService apiService(CompanyProfileDao companyProfileDao,
                                 CompanyMapper companyMapper) {
        return new APIServiceFactory().createAPIService(apiServiceType,
                companyProfileService(companyProfileDao, companyMapper),
                jsonSerialize());
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
