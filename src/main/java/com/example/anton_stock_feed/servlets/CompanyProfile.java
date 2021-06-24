package com.example.anton_stock_feed.servlets;

import com.example.anton_stock_feed.classes.CompanyProfileDAO;
import com.example.anton_stock_feed.classes.CompanyProfileDAOFactory;
import com.example.anton_stock_feed.classes.CompanyProfileService;
import com.example.anton_stock_feed.classes.CompanyProfileServiceFactory;
import com.example.anton_stock_feed.exceptions.CompanyProfileException;
import com.example.anton_stock_feed.model.CompanyClass;
import com.google.gson.Gson;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CompanyProfile", value = "/CompanyProfile")
public class CompanyProfile extends HttpServlet {
    CompanyProfileServiceFactory companyProfileServiceFactory;
    CompanyProfileService companyProfileService;
    CompanyProfileDAOFactory companyProfileDAOFactory;
    CompanyProfileDAO companyProfileDAO;
    String jsonString;
    CompanyClass companyClass;
    String partOfURL;
    String[] partsOfURL;
    String companySymbolFromURL;

    public void init() {
        companyProfileDAOFactory = new CompanyProfileDAOFactory();
        companyProfileDAO = companyProfileDAOFactory.createCompanyProfileDAO("Mock");
        companyProfileServiceFactory = new CompanyProfileServiceFactory();
        companyProfileService = companyProfileServiceFactory.createCompanyProfileService("Mock");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        try {
            partOfURL = request.getRequestURI();
            partsOfURL = partOfURL.split("/");
            companySymbolFromURL = partsOfURL[partsOfURL.length - 1];

            companyClass = companyProfileService.getInfo(companySymbolFromURL, companyProfileDAO);
            Gson gson = new Gson();
            jsonString = gson.toJson(companyClass);
        } catch (Exception e) {
            throw new CompanyProfileException(e);
        }
        PrintWriter out = response.getWriter();

        if (companySymbolFromURL.equals(null)) {
            response.setStatus(404);
        } else {
            out.println(jsonString);
        }

    }

    public void destroy() {
    }
}
