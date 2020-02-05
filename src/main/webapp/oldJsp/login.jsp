<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2020/1/21
  Time: 12:55 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请登录</title>
</head>
<body>
<form action="/welcome/login" method="post">
    <label class="form-label">手机号码</label>
    <div class="input-inline">
        <input type="text" name="telephone" placeholder="请输入登录时注册的手机号">
    </div>
    </div>

    <div class="form-item">
        <label class="form-label">登录密码</label>
        <div class="input-inline">
            <input type="password" name="account_password" placeholder="请输入您的登陆密码">
        </div>
    </div>

    <div class="form-item">
        <div class="input-block">
            <button type="submit">提交</button>
            <button type="reset">重置</button>
        </div>
    </div>
</form>
</body>
</html>
