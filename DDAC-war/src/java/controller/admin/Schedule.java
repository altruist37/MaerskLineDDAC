/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.shipment.Container;
import model.shipment.ContainerFacade;

/**
 *
 * @author abspk
 */
@WebServlet(name = "Schedule", urlPatterns = {"/admin/Schedule"})
public class Schedule extends HttpServlet {

    private String vessel;
    private Date departure;
    private Date arrival;
    private SimpleDateFormat format;
    @EJB
    private ContainerFacade cf;
    private Container container;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            format = new SimpleDateFormat("dd/MM/yy");
            vessel = request.getParameter("route");
            try {
                departure = format.parse(request.getParameter("departure"));
                arrival= format.parse(request.getParameter("arrival"));
            } catch(ParseException x) {
                x.printStackTrace();
            }
            
            container = new Container(vessel, departure, arrival);
            cf.create(container);
            
            
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
