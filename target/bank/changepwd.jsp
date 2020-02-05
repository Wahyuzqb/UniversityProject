<%@ page language="java" contentType="text/html;" pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>修改密码</title>
    <script type="text/javascript">
        function check() {
            var oldpwd = document.getElementById("oldpwd").value;
            var newpwd = document.getElementById("newpwd").value;
            var confirmpwd = document.getElementById("confirmpwd").value;
            if (oldpwd != "" && newpwd != "" && confirmpwd != "") {
                if (newpwd != confirmpwd) {
                    document.getElementById("secondpwd").style.display = "inline";
                    return false;
                }
                return true;
            } else {
                alert("密码不能为空！")
            }
        }
    </script>
</head>
<body>
<center>
    <table height="30">
        <tr>
            <td></td>
        </tr>
    </table>
    <form action="/userManager/changepwd" name="myform" method="post" onsubmit="return check()">
        <table width="50%" height="160" cellpadding="0" cellspacing="0" border="0">
            <tr>
                <td width="15%">当前密码</td>
                <td>
                    <input type="password" id="oldpwd" name="oldpwd">
                    <span style="color:red;">*<s:fielderror name="pwderror" cssStyle="color:red"></s:fielderror></span>
                </td>
            </tr>
            <tr>
                <td>新密码</td>
                <td>
                    <input type="password" id="newpwd" name="newpwd">
                    <span style="color:red;">*</span>
                </td>
            </tr>
            <tr>
                <td>确认密码</td>
                <td>
                    <input type="password" id="confirmpwd" name="confirmpwd">
                    <span style="color:red;">*</span>
                    <span style="display: none;color: red" id="secondpwd">两次密码不一样！</span>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="确定"></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>