<%--
  Created by IntelliJ IDEA.
  User: abspk
  Date: 25/12/2017
  Time: 8:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Maersk CMS | Agent Portal</title>
    <link rel="stylesheet" href="../style/admin.css"/>
    <link rel="stylesheet" href="../style/common.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div class="header">
    <p>Maersk Container Management System | Agent Portal</p>
</div>
<div class="left-panel">
    <div class="innerText">
        <p><a href="./RetrieveContainer">Book Vessel</a></p>
        <p><a href="./RetrieveVessel">Item Registration</a></p>
        <p><a class="selected" href="./register.jsp">Customer Registration</a></p>
    </div>
</div>

<div class="right-panel">
    <div class="pText">
        <form action="./RegisterCustomer" method="post">
            <p>First Name: <input style="margin-left: 37px;" type="text" name="fName" id="fName"/></p>
            <p>Last Name: <input style="margin-left: 37px;" type="text" name="lName" id="lName"/></p>
            <p>Address: <input style="margin-left: 52px;" type="text" name="address" id="address"/></p>
            <p>Email: <input style="margin-left: 69px;" type="text" name="email" id="email"/></p>
            <p>Mobile No.: <input style="margin-left: 35px;" type="tel" name="tel" id="tel"/></p>
            <p>CNIC/Passport: <input style="margin-left: 11px;" type="text" name="passport" id="passport"/></p>
            <input style="margin-left: 114px;" type="submit" value="Submit"/>
        </form>
    </div>
</div>
</body>
</html>