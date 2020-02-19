<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <script src="/js/echarts.js"></script>
    <script type="text/javascript"
            src="/js/jquery-3.2.1.min.js"></script>
</head>
<body>
<div id="main" style="width: 1000px; height: 500px;"></div>
<script type="text/javascript">
    var myChart = echarts.init(document.getElementById('main'));
    var url = '<%=request.getContextPath()%>/userManager/getInOut';
    $.getJSON(url).done(function (json) {
        // 2.获取数据
        money_in = json.inList;//
        money_out = json.outList;//

        // 3.更新图表myChart的数据
        var option = {
            title: {
                text: '收入支出占比',
                left: 'center',
                top: 20,
                textStyle: {
                    color: '#ccc'
                }
            },
            tooltip: {
                trigger: 'item',
                formatter: '{a} <br/>{b} : {c} ({d}%)'
            },
            visualMap: {
                show: false,
                min: 80,
                max: 600,
                inRange: {
                    colorLightness: [0, 1]
                }
            },
            legend: {
                orient: 'vertical',
                left: 10,
                data: ['收入', '支出']
            },
            series: [{
                name: '收支类别',
                type: 'pie',
                radius: '55%',
                center: ['50%', '50%'],
                data: [
                    {value: money_in, name: '收入'},
                    {value: money_out, name: '支出'}
                ].sort(function (a, b) {
                    return a.value - b.value;
                }),
                roseType: 'radius',
                label: {
                    color: 'rgba(60,145,255,0.57)'
                },
                labelLine: {
                    lineStyle: {
                        color: 'rgba(106,178,250,0.88)'
                    },
                    smooth: 0.2,
                    length: 10,
                    length2: 20
                },
                itemStyle: {
                    color: '#c23531',
                    shadowBlur: 200,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                },

                animationType: 'scale',
                animationEasing: 'elasticOut',
                animationDelay: function (idx) {
                    return Math.random() * 200;
                }
            }
            ]
        };

        myChart.setOption(option);
    })
</script>
<a href="/inAndOutList.jsp" class="layui-icon layui-icon-template-1">解锁个人消费流水</a>
</body>
</html>