package com.example.anton_stock_feed.servlets;

import com.example.anton_stock_feed.classes.DataService;
import com.example.anton_stock_feed.classes.DataServiceFactory;
import com.example.anton_stock_feed.classes.RealDataServiceFactory;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CompanyProfile", value = "/CompanyProfile")
public class CompanyProfile extends HttpServlet {
    DataServiceFactory realDataServiceFactory = new RealDataServiceFactory();
    DataService dataService;

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        dataService = realDataServiceFactory.createDataClass("Mock");
        response.setContentType("application/json");
        JSONObject jsonObject = dataService.getInfo();

        PrintWriter out = response.getWriter();
        out.println(jsonObject);
    }

    public void destroy() {
    }
}
    