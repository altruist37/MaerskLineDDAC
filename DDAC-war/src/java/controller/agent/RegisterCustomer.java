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
import javax.servlet.http.HttpSession;
import model.Agent;
import model.AgentFacade;
import model.Customer;
import model.CustomerFacade;

/**
 *
 * @author abspk
 */
@WebServlet(name = "RegisterCustomer", urlPatterns = {"/agent/RegisterCustomer"})
public class RegisterCustomer extends HttpServlet {

    private String fName,lName,address,email,passport, agentEmail;
    private HttpSession session;
    private int tel;
    @EJB
    private CustomerFacade cs;
    private Customer cust;
    @EJB
    private AgentFacade af;
    private Agent agent;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            session = request.getSession(false);
            agentEmail = session.getAttribute("agent").toString();
            agent = af.getAgent(agentEmail);
            
            fName = request.getParameter("fName");
            lName = request.getParameter("lName");
            address = request.getParameter("address");
            email = request.getParameter("email");
            passport = request.getParameter("passport");
            tel = Integer.parseInt(request.getParameter("tel").toString());
            
            //create customer object
            cust = new Customer(fName, lName, address, email, passport, tel, agent);
            cs.create(cust);
            
            response.sendRedirect("./index.jsp");
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
}
