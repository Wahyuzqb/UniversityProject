<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2020/2/7
  Time: 7:38 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/userManager/livings_in_telephone">
    <h2>手机充值：<%=request.getAttribute("telephone")%>
    </h2>
    <div style="display: inline">话费余额</div>
    <input value="<%=request.getAttribute("telephone_balance")%>">
    <div style="display: inline">充值金额</div>
    <input name="telephone_in">
    <button type="submit">确认充值</button>
</form>
</body>
</html>
