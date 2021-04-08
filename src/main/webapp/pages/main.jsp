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
    <link href="/static/layui/css/layui.css" type="text/css" rel="stylesheet"/>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">用户管理系统</div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    <span id="uname"></span>
                </a>
            </li>
            <li class="layui-nav-item"><a href="">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <dl class="layui-nav-child">
                        <dd><a href="/echarts">图表统计</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">用户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/userInfo" id="userInfo">个人信息</a></dd>
                        <dd><a href="/toAddUser">添加用户</a></dd>
                        <dd><a href="/userList">用户列表</a></dd>
                    </dl>

                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">文件管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/toUpload">上传文件</a></dd>
                        <dd><a href="/toDownload">下载文件</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <iframe id="iframeMain" src="/echarts" style="width: 100%" height="100%"></iframe>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>

<script src="/static/js/jquery.js"></script>
<script src="/static/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
    $(function () {

        var user = JSON.parse(window.sessionStorage.getItem("user"));
        $("#uname").text(user.userName)
        $("dd>a").click(function (e) {
            e.preventDefault();
            $("#iframeMain").attr("src",$(this).attr("href"));
        })

    })
</script>

</body>
</html>