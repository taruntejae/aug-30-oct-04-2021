package com.jpmc.lab09;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RequestTrackerServlet", value = "/tracker")
public class RequestTrackerServlet extends HttpServlet {
    private int globalRequestCount; //shared by all the users; it's like a global variable

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        globalRequestCount++;
        PrintWriter out = response.getWriter();
        out.println("<h1>Total request count: " + globalRequestCount + "</h1>");
    }


}
class Person {
    //String name;
}