<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2020/1/20
  Time: 12:18 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎回来！<%=request.getSession().getAttribute("id_account") %>
    </title>
</head>
<body>
<a href="http://localhost:8080/userManager/checkUserInfo">个人基本信息</a>
</body>
</html>
