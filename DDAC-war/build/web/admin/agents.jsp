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
    <link rel="stylesheet" href="../style/admin.css"/>
    <link rel="stylesheet" type="text/css" href="../style/style.css">
    <link rel="stylesheet" type="text/css" href="../style/common.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <% pageContext.setAttribute("list", request.getSession().getAttribute("list")); %>
    
</head>
<body>
<div class="header">
    <p>Maersk Container Management System | Admin Portal</p>
</div>
<div class="left-panel">
    <div class="innerText">
        <p><a href="./schedule.jsp">Schedule</a></p>
        <p><a class="selected" href="./agents.jsp">View Agents</a></p>
        <p><a href="./booking.jsp">View Bookings</a></p>
        <p><a href="./register.jsp">Agent Registration</a></p>
        <p><a href="./report.jsp">Report</a></p>
    </div>
</div>

<div class="right-panel">
    <div class="pText">
        <form action="./RetrieveAgent" method="post">
            <input type="submit" value="Submit" />
        </form>
        
        <table id="table" class="centerP">
            <tr>
                <th>Name</th>
                <th>Address</th>
                <th>Email</th>
                <th>Mobile No</th>
                <th>Assigned Vessels</th> <!-- ORIGINAL WORD -->
            </tr>

            <c:forEach items="${list}" var="p">
                <c:if test="${p != ' ' && p != null}">
                    <tr>
                        <td>${p.name}</td>
                        <!-- Name -->
                        <td>${p.address}</td>
                        <!-- Type -->
                        <td>${p.email}</td>
                        <!-- Mobile -->
                        <td>${p.tel}</td>
                        <!-- Vessel -->
                        <td>${p.vessel}</td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
