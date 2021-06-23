package com.example.anton_stock_feed.servlets;

import com.example.anton_stock_feed.classes.CompanyProfileService;
import com.example.anton_stock_feed.classes.CompanyProfileServiceFactory;
import com.example.anton_stock_feed.exceptions.CompanyProfileException;
import com.example.anton_stock_feed.model.CompanyClass;
import org.json.simple.JSONObject;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CompanyProfile", value = "/CompanyProfile")
public class CompanyProfile extends HttpServlet {
    CompanyProfileServiceFactory companyProfileServiceFactory;
    CompanyProfileService companyProfileService;
    JSONObject jsonObject;
    String companySymbol = "AAPL";
    CompanyClass companyClass;
    String partOfURL;
    String[] partsOfURL;
    String companySymbolFromURL;

    public void init() {
        companyProfileServiceFactory = new CompanyProfileServiceFactory();
        companyProfileService = companyProfileServiceFactory.createCompanyProfileService("Mock");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        try {
            partOfURL = request.getRequestURI();
            partsOfURL = partOfURL.split("/");
            companySymbolFromURL = partsOfURL[partsOfURL.length-1];

            companyClass = companyProfileService.getInfo(companySymbolFromURL);
            jsonObject = new JSONObject();
            jsonObject.put("currency", companyClass.getCurrency());
            jsonObject.put("description", companyClass.getDescription());
            jsonObject.put("displaysymbol", companyClass.getDisplaysymbol());
            jsonObject.put("figi", companyClass.getFigi());
            jsonObject.put("mic", companyClass.getMic());
            jsonObject.put("symbol", companyClass.getSymbol());
            jsonObject.put("type", companyClass.getType());
        } catch (Exception e) {
            throw new CompanyProfileException(e);
        }

        PrintWriter out = response.getWriter();
        out.println(jsonObject);
    }

    public void destroy() {
    }
}
