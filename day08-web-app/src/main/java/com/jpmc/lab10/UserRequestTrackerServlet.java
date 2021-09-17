package com.jpmc.lab10;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/tracker"})
public class UserRequestTrackerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        int requestCount = 0;
        //FIRST TIME SHE IS SENDING THE REQUEST
        if(session.getAttribute("count") == null) {
            requestCount = 1;
        } else { //SUBSEQUENT REQUESTS
            requestCount = (Integer)session.getAttribute("count");
            requestCount++;
        }

        session.setAttribute("count", requestCount);
        PrintWriter out = resp.getWriter();
        out.println("Request count: " + requestCount);
    }
}
