<%@ page import="com.alibaba.fastjson.JSON" %>
<%@ page import="com.alibaba.fastjson.JSONArray" %>
<%@ page import="com.alibaba.fastjson.JSONObject" %>
<%@ page import="com.pojo.Transfers" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html;" pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <script src="/js/jquery-3.2.1.min.js"></script>
    <%--    <script type="text/javascript">--%>
    <%--        // window.onload = requestData();--%>
    <%--        // function requestData(){--%>
    <%--        //     $.ajax(--%>
    <%--        //         {--%>
    <%--        //             url: "http://localhost:8080/info/list",--%>
    <%--        //          type: "POST",--%>
    <%--        //          dataType: "text",--%>
    <%--        //             data: {},--%>
    <%--        //          success: function(data){--%>
    <%--        //                 alert(data);--%>
    <%--        //            showData(data);--%>
    <%--        //          },--%>
    <%--        //             error: function(){--%>
    <%--        //             alert("ajax连接异常");--%>
    <%--        //             }--%>
    <%--        //         });--%>
    <%--        // }--%>
    <%--    // </script>--%>
</head>
<body>
<table id="tab">
    <tr>
        <th>转出账户</th>
        <th>转入账户</th>
        <th>转账金额</th>
        <th>转账日期</th>
    </tr>
    <%
        JSONArray json = JSON.parseArray(request.getAttribute("lists").toString());
        List<Transfers> lists = JSONObject.parseArray(json.toJSONString(), Transfers.class);
        for (int i = 0; i < lists.size(); i++) {
            String myid = lists.get(i).getMyid();
            String otherid = lists.get(i).getOtherid();
            String tr_money = lists.get(i).getTr_money();
            Timestamp datetime = lists.get(i).getDatetime();%>
    <tr>
        <td><%=myid%>
        </td>
        <td><%=otherid%>
        </td>
        <td><%=tr_money%>
        </td>
        <td><%=datetime%>
        </td>
    </tr>
    <%}%>
</table>
</body>
</html>
<%--<script>--%>
<%--    function showData(data) {--%>
<%--        var str = "";--%>
<%--        for(var i =0 ; i<data.length; i++){--%>
<%--            str = "<tr><td>" + data[i].myid + "</td><td>" +data[i].otherid + "</td><td>" +data[i].tr_money +"</td><td>" +data[i].datetime + "</td></tr>";--%>
<%--            $("#tab").append(str);--%>
<%--        }--%>
<%--    }--%>
<%--</script>--%>