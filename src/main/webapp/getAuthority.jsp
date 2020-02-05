<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.alibaba.fastjson.JSON" %>
<%@ page import="com.alibaba.fastjson.JSONArray" %>
<%@ page language="java" contentType="text/html;" pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <script src="/js/jquery-3.2.1.min.js"></script>
</head>
<body>
<tr>
    <th>用户账户</th>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <th>权限获取</th>
</tr>


<%
    JSONArray json = JSON.parseArray(request.getAttribute("lists").toString());
    for (int i = 0; i < json.size(); i++) {
        String account = json.get(i).toString();
%>
<form>
    <div id="div<%=i%>" name="val4account" style="display: inline"><%=account%>
    </div>
    <button id="btn<%=i%>" type="submit" onclick="toDetails()">获取权限</button>
    <script type="text/javascript">
        function toDetails() {
            window.location.href = "http://localhost:8080/admin/jumpToUser.jsp";
        }
    </script>

</form>
<%}%>

</body>
</html>
