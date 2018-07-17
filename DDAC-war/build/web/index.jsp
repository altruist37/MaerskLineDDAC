<%--
  Created by IntelliJ IDEA.
  User: abspk
  Date: 24/12/2017
  Time: 8:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Maersk Line | World's largest container Shipping Company</title>
    <link rel="stylesheet" type="text/css" href="./style/style.css"/>
    <link rel="stylesheet" type="text/css" href="./style/admin.css"/>
    <link rel="stylesheet" type="text/css" href="./style/common.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%
        session.invalidate();
    %>
</head>
<body>
<div class="header" id="mainHeader">
    <p id="headerText">
        <a href="./index.jsp#about">About Us</a>
        <a href="./auth/index.jsp">Admin</a> &nbsp; &nbsp;
        <a href="./auth/index.jsp">Agent</a> &nbsp; &nbsp;
        <a href="./index.jsp#contact">Contact Us</a>
    </p>
</div>
<div class="About-panel" id="about">
    <br/><br/><br/>
    <p class="indexText">At Maersk Line, we move more than cargo. We propel ambitions.
        This means that, whether you run a corner shop or a conglomerate, we have the expertise,
        global network and stability you need to drive your business forward.</p><br/>
    <p class="indexText"><strong>You can ship worldwide with our global network</strong><br/><br/>
        As the world’s largest container shipping company, we move 12 million containers
        every year and deliver to every corner of the globe. Our international presence
        and knowledge of global trade have made us the carrier of choice for the world’s
        biggest brands and those aspiring to be..
        We provide end-to-end transportation to almost anywhere in the world. And, with
        30,000 employees in 114 countries, we combine our global network with local expertise
        to increase the reliability of your deliveries, whether they travel by sea or over land.</p><br/>
    <p class="indexText">
        <strong>You improve your sustainability performance</strong><br/>
        As the world leader in sustainable shipping, we help reduce the environmental impact of your
        supply chain to improve your overall environmental sustainability.
        We have an ambitious target to reduce CO2 emissions from our ocean shipping by 60 percent by
        2020 – we have already achieved a 43 percent reduction, so we are over halfway there – and are
        always looking for new ways to improve our, and your, environmental performance.
    </p>
</div>
<div class="About-panel contact-panel indexText" id="contact">
    <br/><br/>
    <p><strong>Contact Us</strong></p><br/>
    <p>First Name: <input style="margin-left: 57px;" type="text"/></p><br/>
    <p>Last Name: <input style="margin-left: 57px;" type="text"/></p><br/>
    <p>Address: <input style="margin-left: 73px;" type="text"/></p><br/>
    <p>Message: <textarea style="margin-left: 67px;" cols="33" rows="13"></textarea></p><br/> <br/>
    <input style="margin-left: 130px;" type="submit" value="Submit"/>
</div>
<div class="footer indexText">
    <br/><br/>
    <p>Copyright &copy; Maersk Line</p>
</div>
</body>
</html>
