<%--
  Created by IntelliJ IDEA.
  User: abspk
  Date: 25/12/2017
  Time: 8:21 PM
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

        <% pageContext.setAttribute("bookingList", request.getSession().getAttribute("bookingList"));
            pageContext.setAttribute("custList", request.getSession().getAttribute("custList"));
        %>
    </head>
    <body>
        <div class="header">
            <p>Maersk Container Management System | Agent Portal</p>
        </div>
        <div class="left-panel">
            <div class="innerText">
                <p><a href="./RetrieveContainer">Book Vessel</a></p>
                <p><a class="selected" href="./RetrieveVessel">Item Registration</a></p>
                <p><a href="./register.jsp">Customer Registration</a></p>
            </div>
        </div>

        <div class="right-panel">
            <div class="pText">
                <form action="./BookItem" method="post">
                    <p>Item No: <input style="margin-left: 53px;" type="text" name="itemNo" id="itemNo"/></p>
                    <p>Registration No: <input style="margin-left: 5px;" type="text" name="regNo" id="regNo"/></p>
                    <p>Choose Vessel:
                        <select style="margin-left: 12px;" name="route" id="route">
                            <c:forEach items="${bookingList}" var="q">
                                <option value="${q.vessel}">${q.vessel}</option>
                            </c:forEach>

                        </select></p>
                    <p>Choose Customer:
                        <select style="margin-left: 10px;" name="customer" id="customer">
                            <c:forEach items="${custList}" var="c">
                                <option value="${c.email}">${c.fName} &nbsp; ${c.lName} &nbsp; , ${c.email}</option>
                            </c:forEach>

                        </select></p>
                    <p>Generated Price: <input style="margin-left: 5px;" type="text" name="price" id="price"/></p>
                    <input style="margin-left: 114px;" type="submit" value="Submit"/>
                </form>
            </div>
        </div>
    </body>
</html>