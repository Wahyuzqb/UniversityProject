<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2020/2/6
  Time: 12:55 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%
    if (request.getAttribute("isAuthorized") == "0") {
%>
<form action="/admin/activeAccount">
    <div style="display: inline">账户状态</div>
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <button type="submit">等待开户</button>
</form>
<%} else { %>
<form>
    <div style="display: inline">账户状态(已经开户)</div>
</form>
<%}%>

<%
    if (request.getAttribute("hasError") == "0") {
%>
<form action="admin/hasError">
    <div style="display: inline">用户报错</div>
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <button type="submit">等待纠正</button>
</form>
<%} else { %>
<form>
    <div style="display: inline">用户报错(暂无报错)</div>
</form>
<%}%>

<%
    if (request.getAttribute("preSave") == "0") {
%>
<form action="admin/preSave">
    <div style="display: inline">预存款准备</div>
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <button type="submit">查看预存细项</button>
</form>
<%} else { %>
<form>
    <div style="display: inline">预存款准备(无预存准备）</div>
</form>
<%}%>

</body>
</html>
