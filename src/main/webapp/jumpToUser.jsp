<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2020/2/5
  Time: 6:49 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%--<% String account = request.getParameter("val4account");--%>
<%
session.setAttribute("account",request.getParameter("val4account"));
response.setCharacterEncoding("utf-8");
%>
<html>
<head>
    <title></title>
</head>
<body>
<%
    request.getRequestDispatcher("/admin/userNeeds").forward(request,response);
%>
</body>
</html>
