<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2020/1/22
  Time: 8:44 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>验证信息</title>
</head>
<body>
<h2>您输入的账号密码有误，请重新输入！</h2>
<%
    out.println(new Date());
    response.setHeader("refresh","1");
    response.setHeader("refresh","5;URL=http://localhost:8080/login.jsp");
    //一秒刷新页面一次 response.setHeader("refresh","1");

    //二秒跳到其他页面 response.setHeader("refresh","2;URL=otherPagename");
%>
</body>
</html>
