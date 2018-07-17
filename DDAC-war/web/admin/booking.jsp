<%--
  Created by IntelliJ IDEA.
  User: abspk
  Date: 25/12/2017
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Maersk CMS | Admin Portal</title>
        <link rel="stylesheet" type="text/css" href="../style/admin.css"/>
        <link rel="stylesheet" type="text/css" href="../style/style.css"/>
        <link rel="stylesheet" type="text/css" href="../style/common.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" >
        
        <% pageContext.setAttribute("data", request.getSession(false).getAttribute("listBookings")); %>
    </head>
    <body>
        <div class="header">
            <p>Maersk Container Management System | Admin Portal</p>
        </div>
        <div class="left-panel">
            <div class="innerText">
                <p><a href="./schedule.jsp">Schedule</a></p>
                <p><a href="./agents.jsp">View Agents</a></p>
                <p><a class="selected" href="./booking.jsp">View Bookings</a></p>
                <p><a href="./register.jsp">Agent Registration</a></p>
                <p><a href="./report.jsp">Report</a></p>
            </div>
        </div>

        <div class="right-panel">
            <div class="pText">
                <form action="./ListBookings" method="POST">
                    <p><input type="submit" value="Retrieve Bookings" />
                </form>
                <table id="table" class="centerP">
                    <tr>
                        <th>Agent Name</th>
                        <th>Departure Date</th>
                        <th>Arrival Date</th>
                        <th>Shipment No</th>
                        <th>Vessel Journey</th>
                        <th>Total Price</th>
                    </tr>

                    <c:forEach items="${data}" var="p">
                        <c:if test="${p != ' ' && p != null}">
                            <tr>
                                <td>${p.agent.name}</td>
                                <!-- Name -->
                                <td>${p.vessel.departureDate}</td>
                                <!-- Type -->
                                <td>${p.vessel.arrivalDate}</td>
                                <!-- Mobile -->
                                <td>${p.itemNo}</td>
                                <!-- Vessel -->
                                <td>${p.vessel.vessel}</td>
                                <td>${p.price}</td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
