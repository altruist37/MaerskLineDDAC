/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.agent;

import controller.EmailSender;
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
import model.Customer;
import model.CustomerFacade;
import model.shipment.Container;
import model.shipment.ContainerFacade;
import model.shipment.ShipItem;
import model.shipment.ShipItemFacade;

/**
 *
 * @author abspk
 */
@WebServlet(name = "BookItem", urlPatterns = {"/agent/BookItem"})
public class BookItem extends HttpServlet {

    private int regNo, itemNo;
    private String vessel;
    @EJB
    private CustomerFacade cf;
    private Customer customer;
    private double price;
    @EJB
    private ShipItemFacade shipItemFacade;
    private ShipItem shipItem;
    @EJB
    private AgentFacade af;
    private Agent agent;
    @EJB
    private ContainerFacade containerFacade;
    private Container container;
    private String body, to, subject;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            regNo = Integer.parseInt(request.getParameter("regNo"));
            itemNo = Integer.parseInt(request.getParameter("itemNo"));
            price = Double.parseDouble(request.getParameter("price"));
            customer = cf.getCustomer(request.getParameter("customer"));
            vessel = request.getParameter("route");

            agent = af.getAgent(request.getSession(false).getAttribute("agent").toString());
            container = containerFacade.getContainer(vessel);

            shipItem = new ShipItem(customer, container, price, regNo, itemNo, agent);
            shipItemFacade.create(shipItem);

            body = "Dear Sir,<br /><br /> The container has been booked for you. You shall receive email, once it's shipped.<br /><br />Regards,";
            to = customer.getEmail();
            subject = "Container Has been Booked!";

            new EmailSender().sendEmail(to, body, subject);
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
