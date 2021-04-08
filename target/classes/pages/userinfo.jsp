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
    <style type="text/css">
        .content{
            width: 100%;
            position: relative;
            animation: appera 2s;
        }
        @keyframes appera {
            to{
                top: 0;
                opacity: 1;
            }
            from{
                top: 20px;
                opacity: 0;
            }
        }
    </style>
</head>
<body style="padding: 20px; background-color: #F2F2F2;">

<div class="layui-card layui-card-body">
    <div class="content">
        <form class="layui-form" action="">
            <div class="layui-form-item">
                <label class="layui-form-label">请输入账号</label>
                <div class="layui-input-inline">
                    <input type="text" name="title" id="userAccount" required value="${userInfo.userAccount}" disabled lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">请输入姓名</label>
                <div class="layui-input-inline">
                    <input type="text" name="title" id="userName" required value="${userInfo.userName}" lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">请输入密码</label>
                <div class="layui-input-inline">
                    <input type="text" name="password" id="password" required value="${userInfo.password}" lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">请输入年龄</label>
                <div class="layui-input-inline">
                    <input type="text" name="password" id="age" required value="${userInfo.age}" lay-verify="required" placeholder="请输入年龄" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">请输入密码</label>
                <div class="layui-input-inline">
                    <input type="text" name="password" id="gender" required value="${userInfo.gender}" lay-verify="required" placeholder="请输入性别" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button type="button" id="infoBtn" class="layui-btn">提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script type="">
    $("#infoBtn").click(function () {
        $.ajax({
            url:'/user/changeInfo', //请求地址
            type:'POST', //请求类型
            data:{
                //账号密码
                userAccount:$("#userAccount").val(),
                userName:$("#userName").val(),
                password:$("#password").val(),
                age:$("#age").val(),
                gender:$("#gender").val()
            }, //数据
            dataType:'json', //数据类型
            success:function (res){
                if(res.code==20000){
                    layer.msg(res.msg)
                }else if(res.code==50001){
                    window.location.href = '/login'
                }
                else{
                    layer.msg(res.msg)
                }
            }
        })

    })
</script>
</body>
</html>