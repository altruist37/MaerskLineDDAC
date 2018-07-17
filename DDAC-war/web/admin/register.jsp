<%--
  Created by IntelliJ IDEA.
  User: abspk
  Date: 25/12/2017
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Maersk CMS | Admin Portal</title>
    <link rel="stylesheet" href="../style/admin.css"/>
    <link rel="stylesheet" href="../style/common.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div class="header">
    <p>Maersk Container Management System | Admin Portal</p>
</div>
<div class="left-panel">
    <div class="innerText">
        <p><a href="./schedule.jsp">Schedule</a></p>
        <p><a href="./agents.jsp">View Agents</a></p>
        <p><a href="./booking.jsp">View Bookings</a></p>
        <p><a class="selected" href="./register.jsp">Agent Registration</a></p>
        <p><a href="./report.jsp">Report</a></p>
    </div>
</div>

<div class="right-panel">
    <div class="pText">
        <form action="./RegisterAgent" method="post">
            <p>Company Name: <input style="margin-left: 10px;" type="text" name="company" id="company"/></p>
            <p>Email Address: <input style="margin-left: 20px;" type="text" name="email" id="email"/></p>
            <p>Password: <input style="margin-left: 48px;" type="password" name="password" id="password"/></p>
            <p>Address: <input style="margin-left: 57px;" type="text" name="address" id="address"/></p>
            <p>Mobile No.: <input style="margin-left: 40px;" type="tel" name="tel" id="tel"/></p>
            <input style="margin-left: 117px;" type="submit" value="Submit"/>
        </form>
    </div>
</div>
</body>
</html>
