<%@ page import="java.sql.Timestamp" %>
<%@ page import="com.alibaba.fastjson.JSONArray" %>
<%@ page import="com.alibaba.fastjson.JSON" %>
<%@ page import="com.pojo.PreSaves" %>
<%@ page import="com.alibaba.fastjson.JSONObject" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    JSONArray json = JSON.parseArray(request.getAttribute("lists").toString());
    System.out.println("==========" + json);
    List<PreSaves> lists = JSONObject.parseArray(json.toJSONString(), PreSaves.class);
%>

<%
    for (PreSaves pres : lists) {
%>
<form action="/adminManager/checkPres" method="post">

    <tr>
        <th>预存账户</th>
        <th>预存金额</th>
        <th>存款类型</th>
        <th>预定时间</th>
        <th>线下网点</th>
    </tr>
    <%
        Integer id = pres.getId();
        String id_account = pres.getId_account();
        Integer tr_money = pres.getTr_money();
        String deposit_type = pres.getDeposit_type();
        Timestamp save_time = pres.getSave_time();
        String location = pres.getLocation();

    %>
    <tr>
        <input name="id" hidden value="<%=id%>"/>
        <td><%=id_account%>
        </td>
        <input name="id_account" hidden value="<%=id_account%>">
        <td><%=tr_money%>
        </td>
        <input name="tr_money" hidden value="<%=tr_money%>">
        <td><%=deposit_type%>
        </td>
        <input name="deposit_type" hidden value="<%=deposit_type%>">
        <td><%=save_time%>
        </td>
        <input name="save_time" hidden value="<%=save_time%>">
        <td><%=location%>
        </td>
        <input name="location" hidden value="<%=location%>">
    </tr>
    <script type="text/javascript">
        function check4leave() {
            var leaves = document.getElementById("leave").value;
            if (leaves == null)
                return false;
            else
                return true;
        }
    </script>
    退回建议：<input id="leave" placeholder="如同意存款，可以不填写此项"/>
    <button name="btn" value="agree" type="submit" onclick="change()">同意请求</button>
    <button name="btn" value="disagree" type="submit" onclick="return check4leave()">退回请求</button>


    <%}%>


</form>
</body>
</html>
