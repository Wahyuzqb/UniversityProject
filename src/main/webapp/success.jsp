<%@ page language="java" import="java.util.*" contentType="text/html;" pageEncoding="utf-8" %>
<% if (session.getAttribute("id_account") == null) { %>
<jsp:forward page="login.jsp"></jsp:forward>
<% } %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>网上银行系统</title>
    <link href="css/admin.css" type="text/css" rel="stylesheet">
</head>
<frameset border="1" framespacing="0" rows="60,*" frameborder="1">
    <frame name="header" src="/header.jsp" frameborder="1" noresize scrolling="no"/>
    <frameset cols="170,*">
        <frame name="menu" src="/left.jsp" frameborder="1" noresize>
        <frame name="main" src="/main.jsp" frameborder="1" noresize scrolling="yes">
    </frameset>
</frameset>
<noframes>
</noframes>
</html>