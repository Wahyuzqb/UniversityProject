<!DOCTYPE html>
<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" %>
    <meta charset="utf-8">
    <title>table模块快速使用</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
</head>
<body>
<tr>
    <th>收入：<%=request.getAttribute("money_in")%>
    </th>
    <th>支出：<%=request.getAttribute("money_out")%>
    </th>
</tr>
<table id="demo" lay-filter="test"></table>

<script src="/layui/layui.js"></script>
<script>
    layui.use('table', function () {
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#demo'
            , height: 312
            , url: '<%=request.getContextPath()%>/userManager/checkInAndOutMethod' //数据接口
            // , url: '/jsons/InOut.txt' //数据接口
            , method: 'POST'
            , page: true //开启分页
            , cols: [
                [
                    {field: 'myid', title: '转出账户', width: 80}
                    , {field: 'otherid', title: '转入账户', width: 80, sort: true}
                    , {field: 'datetime', title: '交易时间', width: 80}
                    , {field: 'tr_money', title: '交易金额', width: 177}
                ]
            ]
        });

    });
</script>
<a href="/personal_recommend.jsp" class="layui-icon layui-icon-link">查看您的个人财务报表</a>
</body>
</html>