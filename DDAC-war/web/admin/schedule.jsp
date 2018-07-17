<%--
  Created by IntelliJ IDEA.
  User: abspk
  Date: 25/12/2017
  Time: 8:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Maersk CMS | Admin Portal</title>
    <link rel="stylesheet" type="text/css" href="../style/admin.css"/>
    <link rel="stylesheet" type="text/css" href="../style/common.css"/>

    <link rel="stylesheet" type="text/css" href="../style/jquery.datetimepicker.min.css"/>

    <script src="../js/jquery.js"></script>
    <script src="../js/jquery.datetimepicker.js"></script>
    <script src="../js/jquery.datetimepicker.min.js"></script>
    <script src="../js/func.js"></script>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div class="header">
    <p>Maersk Container Management System | Admin Portal</p>
</div>
<div class="left-panel">
    <div class="innerText">
        <p><a class="selected" href="./schedule.jsp">Schedule</a></p>
        <p><a href="./agents.jsp">View Agents</a></p>
        <p><a href="./booking.jsp">View Bookings</a></p>
        <p><a href="./register.jsp">Agent Registration</a></p>
        <p><a href="./report.jsp">Report</a></p>
    </div>
</div>

<div class="right-panel">
    <div class="pText">
        <form action="./Schedule" method="post">
            <p>Sailing Route:
                <select style="margin-left: 70px;" name="route">
                    <option value="KL->JP-A">KL -> JP (A)</option>
                    <option value="KL->CA-B">KL -> CA (B)</option>
                    <option value="KL->CN-C">KL -> CN (C)</option>
                </select></p>
            <p>Sailing Departure Date: &nbsp;<input style="margin-left: 7px;" type="text" name="departure"
                                                    id="datetimepicker8"
                                                    placeholder="Select departure date.."/></p>
            <p>Sailing Arrival Date: &nbsp;<input style="margin-left: 28px;" type="text" name="arrival"
                                                  id="datetimepicker7"
                                                  placeholder="Select arrival date.."/></p>
            <p>Available Space: <input style="margin-left: 51px;" type="text" value="${space}" name="arrival" id="space"
                                       readonly/></p>
            <input style="margin-left: 158px;" type="submit" value="Submit"/>
        </form>
    </div>
</div>
</body>
</html>