<%@ page language="java" contentType="text/html;" pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>欢迎登录网上银行系统</title>
    <script type="text/javascript">

        function login() {
            var hidden = document.getElementById("hidden").value;
            if (document.getElementById("username" + hidden).value == "") {
                alert("用户名不能为空!");
                return false;
            } else if (document.getElementById("password" + hidden).value == "") {
                alert("密码不能为空！");
                return false;
            } else {
                return true;
            }
        }

        function adminlogin() {
            document.getElementById("username1").style.display = "none";
            document.getElementById("password1").style.display = "none";
            document.getElementById("username2").style.display = "block";
            document.getElementById("password2").style.display = "block";
            document.myform.action = "/adminManager/login"
        }

        function init() {
            document.getElementById("username1").style.diaplay = "block";
            document.getElementById("password1").style.display = "block";
            document.getElementById("username2").style.display = "none";
            document.getElementById("password2").style.display = "none";
            document.myform.action = "/welcome/login";
        }

        function change() {
            var select = document.myform.type.value;
            //alert(select);
            if (select == "0") {
                var username2 = document.getElementById("username2").value;
                var password2 = document.getElementById("password2").value;
                init();
                document.getElementById("username1").value = username2;
                document.getElementById("password1").value = password2;
            }
            if (select == "1") {
                var username1 = document.getElementById("username1").value;
                var password1 = document.getElementById("password1").value;
                adminlogin();
                document.getElementById("username2").value = username1;
                document.getElementById("password2").value = password1;
            }
        }
    </script>
</head>
<body onload="init()" style="background-color: #5BD0D9">
<div align="center" style="padding-top: 250px">
    <h2>欢迎登录网上银行系统</h2>
</div>
<div align="center" style="margin-top: 50px">
    <form action="http://localhost:8080/welcome/login" method="post" name="myform" onsubmit="return login()">
        <table width="300" border="0" class="table">
            <tbody>
            <tr height="30px">
                <td>手机号:</td>
                <td>
                    <input id="username1" type="text" name="telephone">
                    <input id="username2" type="text" name="admin_username">
                </td>
            </tr>
            <tr height="30px">
                <td>密　码:</td>
                <td>
                    <input id="password1" type="password" name="account_password">
                    <input id="password2" type="password" name="admin_password">
                </td>
            </tr>
            <tr height="30px">
                <td>类　型:</td>
                <td>
                    <input type="radio" name="type" value="0" onclick="change()" checked>客户 &nbsp;&nbsp;&nbsp;
                    <input type="radio" name="type" value="1" onclick="change()">管理员
                    <!--
                    <select name="type" onchange="change()">
                        <option value="0" selected>客　户</option>
                        <option value="1">管理员</option>
                    </select>
                     -->
                </td>
            </tr>
            <tr height="40px">
                <td></td>
                <td>
                    <input type="submit" id="login" value="登　录">
                    <input type="hidden" id="hidden">
                </td>
            </tr>
            </tbody>
        </table>
        <fielderror fieldName="username" cssStyle="color:red"/>
        <fielderror fieldName="password" cssStyle="color:red"/>
    </form>
</div>
</body>
</html>