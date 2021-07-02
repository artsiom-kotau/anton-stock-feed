package com.example.anton_stock_feed.servlets;

import com.example.anton_stock_feed.service.CompanyProfileDAO;
import com.example.anton_stock_feed.service.CompanyProfileDAOFactory;
import com.example.anton_stock_feed.service.CompanyProfileService;
import com.example.anton_stock_feed.service.CompanyProfileServiceFactory;
import com.example.anton_stock_feed.model.Company;
import com.google.gson.Gson;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "company", value = "/company")
public class CompanyProfile extends HttpServlet {
    CompanyProfileServiceFactory companyProfileServiceFactory;
    CompanyProfileService companyProfileService;
    CompanyProfileDAOFactory companyProfileDAOFactory;
    CompanyProfileDAO companyProfileDAO;

    public void init() {
        companyProfileDAOFactory = new CompanyProfileDAOFactory();
        companyProfileDAO = companyProfileDAOFactory.createCompanyProfileDAO("Database");
        companyProfileServiceFactory = new CompanyProfileServiceFactory();
        companyProfileService = companyProfileServiceFactory.createCompanyProfileService("Database", companyProfileDAO);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Company company;
        String partOfURL;
        String[] partsOfURL;
        String companySymbolFromURL;
        partOfURL = request.getRequestURI();
        partsOfURL = partOfURL.split("/");
        companySymbolFromURL = partsOfURL[partsOfURL.length - 1];
        String jsonString = null;
        response.setContentType("application/json");
        try {
            company = companyProfileService.getInfo(companySymbolFromURL);
            Gson gson = new Gson();
            jsonString = gson.toJson(company);
        } catch (Exception e) {
            response.setStatus(500);
            response.getWriter().println(e.getMessage());
        }
        PrintWriter out = response.getWriter();

        if (companySymbolFromURL.equals("company")) {
            response.setStatus(404);
            response.getWriter().println("No such company");
        } else {
            out.println(jsonString);
        }
    }

    public void destroy() {
    }
}
