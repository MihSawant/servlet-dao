<%--
  Created by IntelliJ IDEA.
  User: mihirsanjaysawant
  Date: 08/04/23
  Time: 11:03 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register New user</title>
</head>
<style>
    form>div{
        padding: 20px;
    }
</style>
<body>
<form action="update" method="post">
    <div>
        Enter Name: <input type="text" name="name"/>
    </div>
    <div>
        Enter Designation: <input type="text" name="designation"/>
    </div>
    <div>
        <input type="submit" value="Updte Record"/>
    </div>
</form>
</body>
</html>
