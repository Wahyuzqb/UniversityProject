<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2020/1/21
  Time: 9:37 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请确认您的信息</title>
</head>
<body>
<h2>请输入提前预留的手机号</h2>
<form action="/welcome/checkUserTele" method="post">
    <label class="form-label">手机卡号</label>
    <div class="input-inline">
        <input type="text" name="telephone" placeholder="请输入预留的手机号">
    </div>
    </div>

    <div class="form-item">
        <div class="input-block">
            <button type="submit">提交</button>
            <button type="reset">重置</button>
        </div>
    </div>
</form>
<h4><%=request.getSession().getAttribute("teleMsg")%></h4>
</body>
</html>
