package com.example.anton_stock_feed.controller;

import com.example.anton_stock_feed.dao.ReportDao;
import com.example.anton_stock_feed.dto.CompanyDto;
import com.example.anton_stock_feed.dto.ReportDto;
import com.example.anton_stock_feed.entity.ReportEntity;
import com.example.anton_stock_feed.service.CompanyProfileService;
import com.example.anton_stock_feed.service.ReportService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/addreport")
public class CompanyProfilePostController {
    CompanyProfileService companyProfileService;
    ReportService reportService;
    ReportDao reportDao;

    public CompanyProfilePostController(CompanyProfileService companyProfileService,
                                        ReportDao reportDao,
                                        ReportService reportService) {
        this.companyProfileService = companyProfileService;
        this.reportDao = reportDao;
        this.reportService = reportService;
    }

    @PostMapping
    public CompanyDto addReport(@RequestBody String displaySymbol) {
        CompanyDto company = companyProfileService.findByDisplaySymbol(displaySymbol);
        List<ReportDto> reportDtos = company.getReports();
//        ReportEntity reportEntity = new ReportEntity('320193', '0000320193-19-000119', '2019', '0', '10-K', '2018-09-30 00:00:00',
//                '2019-09-28 00:00:00', '2019-10-31 00:00:00', '2019-10-30 18:12:36', 'report 2019', 'AAPL');
        ReportEntity reportEntity = new ReportEntity("320193", "0000320193-19-000119", "2019", "0", "10-K", "2018-09-30 00:00:00",
                "2019-09-28 00:00:00", "2019-10-31 00:00:00", "2019-10-30 18:12:36", "report 2019", "AAPL");

        reportService.saveAll((Iterable<ReportEntity>) reportEntity);
//        System.out.println(reportService.save((Iterable<ReportEntity>) reportEntity));

        //Iterable<ReportEntity>

        return company;
    }
}
