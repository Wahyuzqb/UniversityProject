<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2020/1/20
  Time: 12:14 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@page import="java.util.*" %>
<html>
<head>
    <title>验证消息</title>
</head>
<body>
<h2>您输入的账号已存在、或者不属于该行，无法注册，请检查后重试！</h2>
时间：<%
    out.println(new Date());
    response.setHeader("refresh","1");
    response.setHeader("refresh","5;URL=http://localhost:8080/index.jsp");
    //一秒刷新页面一次 response.setHeader("refresh","1");

    //二秒跳到其他页面 response.setHeader("refresh","2;URL=otherPagename");
%>
</body>
</html>
