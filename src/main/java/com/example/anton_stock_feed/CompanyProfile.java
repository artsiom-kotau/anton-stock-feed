package com.example.anton_stock_feed;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CompanyProfile", value = "/CompanyProfile")
public class CompanyProfile extends HttpServlet {
    private String message1;
    private String message2;

    public void init() {
        message1 = "Company profile";
        DatabaseToController databaseToController = new DatabaseToController();
        message2 = databaseToController.getInfo();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message1 + "</h1>");
        out.println(message2 + "<br>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
