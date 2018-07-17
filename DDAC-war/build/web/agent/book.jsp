<%--
  Created by IntelliJ IDEA.
  User: abspk
  Date: 25/12/2017
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Maersk CMS | Agent Portal</title>
        <link rel="stylesheet" type="text/css" href="../style/admin.css"/>
        <link rel="stylesheet" type="text/css" href="../style/common.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <% pageContext.setAttribute("containerList", request.getSession(false).getAttribute("containerList")); %>
    </head>
    <body>
        <div class="header">
            <p>Maersk Container Management System | Agent Portal</p>
        </div>
        <div class="left-panel">
            <div class="innerText">
                <p><a class="selected" href="./RetrieveContainer">Book Vessel</a></p>
                <p><a href="./RetrieveVessel">Item Registration</a></p>
                <p><a href="./register.jsp">Customer Registration</a></p>
            </div>
        </div>

        <div class="right-panel">
            <div class="pText">
                <form action="./BookVessel" method="post">
                    <p>Choose Vessel:
                        <select style="margin-left: 12px;" name="route" id="route">
                            <c:forEach items="${containerList}" var="a">
                                <option value="${a.vessel}">${a.vessel} | Departure: ${a.departureDate} | Arrival: ${a.arrivalDate}</option>
                            </c:forEach>

                        </select></p>
                    <p>Remaining Space: <input style="margin-left: 5px;" type="text" name="space" id="space" readonly/></p>
                    <input style="margin-left: 122px;" type="submit" value="Submit"/>
                </form>
            </div>
        </div>
    </body>
</html>