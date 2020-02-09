<%@ page language="java" contentType="text/html;" pageEncoding="utf-8" %>
<%--<% --%>
<%--   java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(  --%>
<%--     "yyyy-MM-dd HH:mm:ss");  --%>
<%--   java.util.Date currentTime = new java.util.Date();  --%>
<%--   String time = simpleDateFormat.format(currentTime).toString();  --%>
<%--%>--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>存款</title>
    <script type="text/javascript">

        // function disptime(){
        // 	var now=new Date();
        //
        // 	var year=now.getFullYear();
        // 	var month=now.getMonth()+1;
        // 	var date=now.getDate();
        // 	var hour=now.getHours();
        // 	var minute=now.getMinutes();
        // 	var second =now.getSeconds();
        // 		document.getElementById("datetime").value=year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
        // 		//year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
        // 		setTimeout("disptime()", 1000);
        // }

        /*更改利息*/
        function changeRates() {
            var money = document.getElementById("tr_money").value;
            var type = document.getElementById("type_select").value;
            if (money == null || type == null)
                document.getElementById("rates").value = '0';
            else {
                if (type == "hq")
                    document.getElementById("rates").value = parseInt(money) * 0.003;
                if (type = "cbqx")
                    document.getElementById("rates").value = parseInt(money) * 0.0135;
                if (type = "zczq")
                    document.getElementById("rates").value = parseInt(money) * 0.0175;
            }
        }

        //判断用户输入的存款金额是否合理
        function deposit() {
            var money = document.getElementById("tr_money").value;
            //alert(money.length);
            if (money.length > 0) {
                if (!(money.search(/^[\+\-]?\d+\.?\d*$/) == 0)) {
                    document.getElementById("errormoney").innerHTML = "含有非法字符!";
                    return false;
                } else {
                    if (parseFloat(money) == 0) {
                        document.getElementById("errormoney").innerHTML = "金额必须大于0!";
                        return false;
                    }
                    return confirm("确认存款吗?");
                }
            } else {
                document.getElementById("errormoney").innerHTML = "金额不能为空！";
                return false;
            }
        }

    </script>
</head>
<body>
<form action="/userManager/deposit" name="myform" method="post" onsubmit="return deposit()">
    <div align="center">
        <table>
            <tbody>
            <%--                    <tr>--%>
            <%--                    <td>预约存款时间：</td>--%>
            <%--                    <td width="360" height="30">--%>
            <%--                        <input type="text" name="log.datetime" id="datetime" />--%>
            <%--                    </td>--%>
            <%--                </tr>--%>
            <tr>
                <td>预约存款时间：</td>
                <td width="360" height="30">
                    <input type="date" name="log.datetime" id="datetime"/>
                </td>
            </tr>
            <tr>
                <td>预约存款地点：</td>
                <td width="360" height="30">
                    <select name="location">
                        <option value="1">独山大道与信臣路交汇处分行</option>
                        <option value="2">建设中路1089号</option>
                        <option value="3">建设路与文化路交叉口向东80米路北</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>预约存款种类：</td>
                <td width="360" height="30">
                    <select name="deposit_type" id="type_select" onblur="changeRates()">
                        <option value="hq">活期存款</option>
                        <option value="cbqx">存本取息</option>
                        <option value="zczq">整存整取</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>存款金额：</td>
                <td width="360" height="30">
                    <input type="text" name="log.tr_money" id="tr_money" onblur="changeRates()"/>
                    <span id="errormoney" style="color:red;"></span>
                </td>
            </tr>
            <tr>
                <td>预计年利息：</td>
                <td width="360" height="30">
                    <input id="rates" type="text"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td width="360" height="30">
                    <input type="submit" value="确认预约"/>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</form>
</body>
</html>