/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.agent;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Agent;
import model.AgentFacade;

/**
 *
 * @author abspk
 */
@WebServlet(name = "RegisterAgent", urlPatterns = {"/admin/RegisterAgent"})
public class RegisterAgent extends HttpServlet {
    private String company;
    private String email;
    private String password;
    private int tel;
    private String address;
    @EJB
    private AgentFacade agentFacade;
    private Agent agent;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            company = request.getParameter("company");
            email = request.getParameter("email");
            password = request.getParameter("password");
            tel = Integer.parseInt(request.getParameter("tel"));
            address = request.getParameter("address");
            
            agent = new Agent(email, company, address, tel, password, "NULL");
            try {
                agentFacade.create(agent);
                
                response.sendRedirect("/admin/index.jsp");
            } catch (Exception x) {
                x.printStackTrace();
                response.sendRedirect("/admin/index.jsp");
            }
            
        }
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
