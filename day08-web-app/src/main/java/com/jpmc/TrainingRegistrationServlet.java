package com.jpmc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/register"})
public class TrainingRegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("firstname");
        String message = String.format("Hey %s, Thanks for your interest in the training", name);
        HttpSession session = req.getSession(true);
        session.setAttribute("msg", message);
        resp.sendRedirect("/day08-web-app/output.jsp");

        //PrintWriter out = resp.getWriter();
        //String name = req.getParameter("firstname");
        //String message = String.format("Hey %s, Thanks for your interest in the training", name);
        //out.println(message);
    }
}
