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
        message2 = "{\"country\":\"US\",\"currency\":\"USD\",\"exchange\":\"NASDAQ NMS - GLOBAL MARKET\",\"finnhubIndustry\":\"Technology\",\"ipo\":\"1980-12-12\",\"logo\":\"https://finnhub.io/api/logo?symbol=AAPL\",\"marketCapitalization\":2163385,\"name\":\"Apple Inc\",\"phone\":\"14089961010.0\",\"shareOutstanding\":16687.631,\"ticker\":\"AAPL\",\"weburl\":\"https://www.apple.com/\"}";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message1 + "</h1>");
        out.println(message2);
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
