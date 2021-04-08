<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"+ request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath %>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/layui/css/modules/layer/default/layer.css">

    <script src="/static/js/jquery.js"></script>
    <script src="/static/layui/layui.js"></script>
    <script src="/static/layui/lay/modules/layer.js"></script>
    <script src="/static/charts/echarts.min.js"></script>
    <style type="text/css">
        .content{
            display: flex;
            justify-content: center;
            align-items: center;
            flex-wrap: wrap;
        }

    </style>
</head>
<body style="padding: 20px; background-color: #F2F2F2;">
<div class="layui-card layui-card-body content">
    <div id="main1" style="width: 600px;height: 400px;"></div>
    <div id="main2" style="width: 600px;height: 400px;"></div>
</div>

<script>
    //条形统计图
    $(function (){
        $.ajax({
            url:'/userGender', //请求地址
            type:'Get', //请求类型
            dataType:'json', //数据类型
            success:function (res){
                var gender=[];
                var num = [];
                gender.push(res[0].gender);
                gender.push(res[1].gender);
                num.push(res[0].num);
                num.push(res[1].num);

                // 基于准备好的dom，初始化echarts实例
                var myChart = echarts.init(document.getElementById('main1'));

                // 指定图表的配置项和数据
                var option = {
                    title: {
                        text: '用户男女人数统计'
                    },
                    tooltip: {},
                    legend: {
                        data:['人数']
                    },
                    xAxis: {
                        data: gender
                    },
                    yAxis: {},
                    series: [{
                        name: '人数',
                        type: 'bar',
                        data: num
                    }]
                };

                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);

            }
        })
    })

    // 扇形统计图
    $(function (){
        $.ajax({
            url:'/userAge', //请求地址
            type:'Get', //请求类型
            dataType:'json', //数据类型
            success:function (res){
                var chartDom = document.getElementById('main2');
                var myChart = echarts.init(chartDom);

                var ageNum = [

                ]
                for (let i = 0; i < res.length; i++) {
                    ageNum.push({value:(res[i].value*100),name:res[i].name});
                }

                var option= {
                    backgroundColor: '#2c343c',
                    visualMap: {
                        show: false,
                        min: 80,
                        max: 600,
                        inRange: {
                            colorLightness: [0, 1]
                        }
                    },
                    series : [
                        {
                            name: '访问来源',
                            type: 'pie',
                            radius: '55%',
                            data: ageNum,
                            roseType: 'angle',
                            label: {
                                normal: {
                                    textStyle: {
                                        color: 'rgba(255, 244, 255, 0.5)'
                                    }
                                }
                            },
                            labelLine: {
                                normal: {
                                    lineStyle: {
                                        color: 'rgba(255, 255, 255, 0.5)'
                                    }
                                }
                            },
                            itemStyle: {
                                normal: {
                                    color: '#c23531',
                                    shadowBlur: 200,
                                    shadowColor: 'rgba(0, 0, 0, 0.2)'
                                }
                            }
                        }
                    ]
                };
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            }
        })
    })




</script>

</body>
</html>