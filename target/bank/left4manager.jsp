<%@ page language="java" contentType="text/html;" pageEncoding="utf-8" %>
<html>
<head>
    <title>Insert title here</title>
    <link href="css/admin.css" type="text/css" rel="stylesheet">
</head>
<body>
<table width="170" height="100%" cellspacing="0" cellpadding="0" background="images/menu_bg.jpg" border="0">
    <tr>
        <td valign="top" align="center">
            <table width="150" cellpadding="0" cellspacing="0" border="0">
                <tr height="25">
                    <td style="padding-left: 30px" background="images/menu_bt.jpg">
                        <a style="font-size: 15px" class="menuParent" onclick="expend(1)" href="javascript:void(0);">操作菜单</a>
                    </td>
                </tr>
                <tr height="6">
                    <td></td>
                </tr>
            </table>
            <table id="child0" width="150" cellpadding="0" cellspacing="0" border="0">
                <tr height="20">
                    <td width="30" align="center">
                        <img width="9" height="9" src="images/menu_icon.gif">
                    </td>
                    <td>
                        <a id="menuChild" style="font-size: 13px" href="http://localhost:8080/adminManager/getAuthority" target="main">获取权限</a>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>