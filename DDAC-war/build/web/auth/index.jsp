<%--
  Created by IntelliJ IDEA.
  User: abspk
  Date: 25/12/2017
  Time: 12:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Maersk - CMS | Login Panel</title>
    <link rel="stylesheet" type="text/css" href="../style/style.css"/>
    <link rel="stylesheet" type="text/css" href="../style/common.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%
        pageContext.setAttribute("inCorrect", request.getSession().getAttribute("inCorrect"));
    %>
</head>
<body>
<div>
    <form method="post" action="/Login">

        <input type="radio" name="type" id="type" value="admin"> Admin<br/>
        <input type="radio" name="type" id="type" value="agent"> Agent<br/>
        <input type="text" name="username" id="username" placeholder="example@domain.com"/><br/>
        <input type="password" name="password" id="password" placeholder="password..."/><br/>

        <input type="submit" value="Submit"/>
        <c:out value="${inCorrect}"/>
    </form>
</div>
</body>
</html>
