<%--
  Created by IntelliJ IDEA.
  User: XCHD
  Date: 2019/9/2
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user/register.do" method="get">
    姓名:<input type="text" name="name">${nameError}<br>
    年龄:<input type="text" name="age">${ageError}<br>
    手机:<input type="text" name="phone">${phoneError}<br>
    <input type="submit" value="提交">
</form>
</body>
</html>
