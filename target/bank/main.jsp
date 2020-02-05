<%@ page language="java" contentType="text/html;" pageEncoding="utf-8" %>
<%
    java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");
    java.util.Date currentTime = new java.util.Date();
    String time = simpleDateFormat.format(currentTime).toString();
%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
<link href="css/admin.css" type="text/css" rel="stylesheet">
<table width="100%" cellpadding="0" cellspacing="0" align="center" background="images/main_bg.jpg">
    <tr height="28">
        <td style="font-size: 14px" background="images/title_bg1.jpg">&nbsp;&nbsp;当前位置：</td>
    </tr>
    <tr>
        <td bgcolor="#b1ceef" height="2"></td>
    </tr>
    <tr height=20>
        <td background=images/shadow_bg.jpg></td>
    </tr>
</table>
<table width="90%" cellpadding="0" cellspacing="0" border="0">
    <tr>
        <td height="50" colspan="4"></td>
    </tr>
    <tr height="100">
        <td height="100" width="40"></td>
        <td height="100" width="90">
            <img height="100" width="90" src="images/admin_p.gif">
        </td>
        <td width="80"></td>
        <td>
            <table height="100" width="100%" cellpadding="0" cellspacing="0" border="0">
                <tr>
                    <td style="FONT-WEIGHT: bold; FONT-SIZE: 16px; color: red">
                        您登录时间：  <%=time %>
                    </td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td style="FONT-WEIGHT: bold; FONT-SIZE: 16px; color: red">
                        欢迎进入网上银行交易中心！
                    </td>
                </tr>
            </table>
        </td>
    <tr>
        <td height="10" colspan="4"></td>
    </tr>
</table>
</body>
</html>