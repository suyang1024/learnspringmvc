<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/user/addUser.do" method="post">
        姓名:<input type="text" name="name"><br>
        年龄:<input type="text" name="age"><br>
        生日:<input type="date" name="birthday"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
