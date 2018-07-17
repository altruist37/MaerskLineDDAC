/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Admin;
import model.AdminFacade;
import model.AgentFacade;

/**
 *
 * @author abspk
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    private String username;
    private String password;
    private String type;
    private HttpSession session = null;

    @EJB
    private AdminFacade adminFacade;
    private Admin admin;
    @EJB
    private AgentFacade agentFacade;
    private boolean bool = false;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //admin = new Admin();
            //admin.setEmail("uzair@linux.com");
            //admin.setPassword("123456789");
            //adminFacade.create(admin);
            username = request.getParameter("username");
            password = request.getParameter("password");
            type = request.getParameter("type");

            if (type.equals("agent")) {
                //AGENT
                bool = agentFacade.getLogin(username, password);
                if (bool) {
                    session = request.getSession(true);
                    session.setAttribute("agent", username);
                    response.sendRedirect("/agent/index.jsp");
                } else {
                    redirect(request, response);
                }

            } else if (type.equals("admin")) {
                //ADMIN
                bool = adminFacade.getLogin(username, password);
                if (bool) {
                    session = request.getSession(true);
                    session.setAttribute("admin", username);
                    response.sendRedirect("/admin/index.jsp");
                } else {
                    redirect(request, response);
                }

            } else {
                redirect(request, response);
            }
        }
    }

    private void redirect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("inCorrect", "Wrong username/password.\n\nPlease try again!");
        response.sendRedirect("/auth/index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
