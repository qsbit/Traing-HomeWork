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
</head>
<body style="padding: 20px; background-color: #F2F2F2;">


<div class="layui-card layui-card-body">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-inline">
                <input type="text" id="userName" name="userName" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
                <input type="password" id="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
        </div>
        <button id="loginBtn" type="button" class="layui-btn">登录</button>
    </form>
</div>

<script type="text/javascript">
    $(function () {
        if(window != top){
            top.location.href = location.href;
        }
        $("#loginBtn").click(function () {
            $.ajax({
                url:'/login', //请求地址
                type:'POST', //请求类型
                data:{
                    //用户名，密码
                    userName:$("#userName").val(),
                    password:$("#password").val()
                }, //数据
                dataType:'json', //数据类型
                success:function (res){
                    alert("code:"+res.code + " msg:"+res.msg +" 用户名："+res.userName+" 密码："+res.password)
                }
            })
        })
    })
</script>

</body>
</html>