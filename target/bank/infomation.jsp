<%@ page language="java" contentType="text/html;" pageEncoding="utf-8" %>
<%--<script type="text/javascript">--%>

<%--    var xhr = new XMLHttpRequest();--%>
<%--    xhr.open("GET", "http://localhost:8080/userManager/checkUserBalance", true);--%>
<%--    xhr.send();--%>


<%--</script>--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>个人信息详情</title>
</head>

<body>
<div id="message">

</div>
<%--<script>--%>
<%--    document.getElementById("message").innerHTML = '12345';--%>
<%--</script>--%>
<div align="center">
    <table width="450" class="table" cellpadding="0" cellspacing="0" border="0">
        <tbody>
        <tr>
            <td>卡号　ID：</td>
            <td width="360" height="30">
                <input type="text" name="user.accountid" value="<%=request.getSession().getAttribute("id_account")%>"/>
            </td>
        </tr>
        <%--                <tr>--%>
        <%--                    <td>姓　　名：</td>--%>
        <%--                    <td width="360" height="30">--%>
        <%--                        <input type="text" name="personinfo.realname" value="${personinfo.realname}" />--%>
        <%--                    </td>--%>
        <%--                </tr>--%>
        <%--                <tr>--%>
        <%--                    <td>年　　龄：</td>--%>
        <%--                    <td width="360" height="30">--%>
        <%--                        <input type="text" name="personinfo.age" value="${personinfo.age}" />--%>
        <%--                    </td>--%>
        <%--                </tr>--%>
        <%--                <tr>--%>
        <%--                    <td>性　　别：</td>--%>
        <%--                    <td width="360" height="30">--%>
        <%--                        <input type="text" name="personinfo.sex" value="${personinfo.sex}" />--%>
        <%--                    </td>--%>
        <%--                </tr>--%>
        <%--                <tr>--%>
        <%--                    <td>家庭住址：</td>--%>
        <%--                    <td width="360" height="30">--%>
        <%--                        <input type="text" name="personinfo.address" value="${personinfo.address}" />--%>
        <%--                    </td>--%>
        <%--                </tr>--%>
        <tr>
            <td>联系电话：</td>
            <td width="360" height="30">
                <input type="text" name="personinfo.telephone"
                       value="<%=request.getSession().getAttribute("telephone")%>"/>
            </td>
        </tr>
        <%--                <tr>--%>
        <%--                    <td>身份证号：</td>--%>
        <%--                    <td width="360" height="30">--%>
        <%--                        <input type="text" name="personinfo.cardid" value="${personinfo.cardid}" />--%>
        <%--                    </td>--%>
        <%--                </tr>--%>

        <tr>
            <td>账户余额：</td>
            <td width="360" height="30">
                <input type="text" name="user.balance" value="<%=request.getSession().getAttribute("card_balance")%>"/>
            </td>
        </tr>
        </tbody>
    </table>

</div>
</body>

</html>