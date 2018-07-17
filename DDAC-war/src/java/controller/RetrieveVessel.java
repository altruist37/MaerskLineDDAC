/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Agent;
import model.AgentFacade;
import model.Booking;
import model.BookingFacade;
import model.Customer;
import model.CustomerFacade;

/**
 *
 * @author abspk
 */
@WebServlet(name = "RetrieveVessel", urlPatterns = {"/agent/RetrieveVessel"})
public class RetrieveVessel extends HttpServlet {

    @EJB
    private AgentFacade af;
    private Agent agent = null;
    
    @EJB
    private BookingFacade bf;
    private List<Booking> booking;
    @EJB
    private CustomerFacade cf;
    private List<Customer> cust;
    
    private HttpSession session;
    private String email;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            session = request.getSession(false);
            email = session.getAttribute("agent").toString();
           
            agent = af.getAgent(email);
            booking = bf.getBookings(agent);
            cust = cf.getCustomer(agent);
            
            session.setAttribute("bookingList", booking);
            session.setAttribute("custList", cust);
            response.sendRedirect("./register_item.jsp");
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
