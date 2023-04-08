<%@ page import="java.util.List" %>
<%@ page import="sawant.mihir.jspdaopattern.entities.User" %><%--
  Created by IntelliJ IDEA.
  User: mihirsanjaysawant
  Date: 08/04/23
  Time: 10:39 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JDBC-SERVLET</title>
</head>
<body>
<% List<User> users = (List<User>) request.getAttribute("users");%>
<%
    for(User u : users){
        out.println("<br/>" + u.getName()+ " " + u.getDesignation());
    }%>
</body>
</html>
