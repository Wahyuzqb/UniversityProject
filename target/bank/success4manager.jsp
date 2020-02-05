<%@ page language="java" import="java.util.*" contentType="text/html;" pageEncoding="utf-8" %>
<% if (session.getAttribute("manager_no") == null) { %>
<jsp:forward page="login4manager.jsp"></jsp:forward>
<% } %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>管理系统</title>
    <link href="css/admin.css" type="text/css" rel="stylesheet">
</head>
<frameset border="1" framespacing="0" rows="60,*" frameborder="1">
    <frame name="header" src="/header4manager.jsp" frameborder="1" noresize scrolling="no"/>
    <frameset cols="170,*">
        <frame name="menu" src="/left4manager.jsp" frameborder="1" noresize>
        <frame name="main" src="/main.jsp" frameborder="1" noresize scrolling="yes">
    </frameset>
</frameset>
<noframes>
</noframes>
</html>