<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2020/2/7
  Time: 7:39 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/userManager/livings_in_water">
    <%
        if (request.getAttribute("account2water") != null) {
    %>
    <h2>水费充值：<%=request.getAttribute("account2water")%>
    </h2>
    <div style="display: inline">水费余额</div>
    <input value="<%=request.getAttribute("water_balance")%>">
    <div style="display: inline">充值金额</div>
    <input name="water_in">
    <button type="submit">确认充值</button>
    <%
    } else {
    %>
    <div>您尚未开通网上税费代缴功能，请前往银行柜台办理。如已经办理，请点击报错按钮等待稍后后台回复。</div>
    <%
        }
    %>
</form>
</body>
</html>
