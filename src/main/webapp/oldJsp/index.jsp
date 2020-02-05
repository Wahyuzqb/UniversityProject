<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<html>
<body>
<h2>注册页面</h2>
<form action="/welcome/regist" method="post">
    <label class="form-label">银行卡号</label>
    <div class="input-inline">
        <input type="text" name="id_account" placeholder="请输入您在该行持有的银行卡号">
    </div>
    </div>

    <div class="form-item">
        <label class="form-label">设置密码</label>
        <div class="input-inline">
            <input type="password" name="account_password" placeholder="请设置您的登陆密码">
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
