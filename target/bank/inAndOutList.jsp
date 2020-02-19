<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <script src="js/echarts.js"></script>
    <script type="text/javascript"
            src="/js/jquery-3.2.1.min.js"></script>
</head>
<body>
<div id="main" style="width: 1000px; height: 500px;"></div>
<script type="text/javascript">
    alert("1");
    var myChart = echarts.init(document.getElementById('main'));
    myChart.showLoading();
    var url = '<%=request.getContextPath()%>/userManager/getInOutList';
    $.getJSON(url).done(function (json) {
        myChart.hideLoading();
        // 2.获取数据
        money_in_list = json.inList;//
        money_out_list = json.outList;//
        alert(money_out_list);
        myChart.setOption({
            xAxis: {
                type: 'category',
                data: []
            },
            yAxis: {
                type: 'value',
                axisLabel: {
                    formatter: '{value}(¥)'
                }
            },
            legend: {
                data: ['收入', '支出']
            },
            series: [
                {name: '支出',
                data: getData(),
                type: 'line',
                itemStyle: {normal: {label: {show: true}}}
            },{
                name: '收入',
                data: getData2(),
                    type: 'line',
                    itemStyle: {normal: {label: {show: true}}}
                }]
        });
    });

    function getData() {
        var jsonstr = [];
        for (var i = 0; i < money_out_list.length; i++) {
            var json = {};
            json = money_out_list[i];
            jsonstr.push(json);
        }
        return jsonstr;
    }
    function getData2() {
        var jsonstr = [];
        for (var i = 0; i < money_in_list.length; i++) {
            var json = {};
            json = money_in_list[i];
            jsonstr.push(json);
        }
        return jsonstr;
    }
</script>
</body>
</html>
