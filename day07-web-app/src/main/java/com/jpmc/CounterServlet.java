package com.jpmc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;


@WebServlet(urlPatterns = {"/counter", "/newcounter"})
public class CounterServlet extends HttpServlet {
    //Since a servlet instance is shared by all the users; YOU NEVER WRITE user specific code in the servlet;
    //No member variables in the servlet class;
    //Servlets are usually designed to be stateless

    private static int count;
    public CounterServlet() {
        count++;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String message = "Response received from " + this + ": Servlet count: (" + count + ")";
        out.println(message);
    }


}
