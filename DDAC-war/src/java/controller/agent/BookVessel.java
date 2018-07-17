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
import model.Booking;
import model.BookingFacade;

/**
 *
 * @author abspk
 */
@WebServlet(name = "BookVessel", urlPatterns = {"/agent/BookVessel"})
public class BookVessel extends HttpServlet {
    
    private String route;
    @EJB
    private AgentFacade agentFacade;
    private Agent agent;
    private HttpSession session;
    @EJB
    private BookingFacade bf;
    private Booking booking;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            session = request.getSession(false);
            route = request.getParameter("route");
            String s = session.getAttribute("agent").toString();
            agent = agentFacade.getAgent(s);
            booking = new Booking(agent, route);
            
            agentFacade.upAgent(route, s);
            bf.create(booking);
            
            request.getRequestDispatcher("./index.jsp").forward(request, response);
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
