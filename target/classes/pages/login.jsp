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
    <link href="/static/css/sb-admin-2.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/layui/css/modules/layer/default/layer.css">

    <script src="/static/js/jquery.js"></script>
    <script src="/static/layui/layui.js"></script>
    <script src="/static/layui/lay/modules/layer.js"></script>
</head>
<body class="bg-gradient-primary">

<div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center">

        <div class="col-xl-10 col-lg-12 col-md-9">

            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
                    <div class="row">
                        <div class="col-lg-6 d-none d-lg-block bg-login-image">
                        </div>
                        <div class="col-lg-6">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">欢迎回来!</h1>
                                </div>
                                <form class="user" action="/user/login" method="post">
                                    <div class="form-group">
                                        <input type="text" class="form-control form-control-user" id="userAccount" name="userAccount" placeholder="请输入账号">
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control form-control-user" id="password" name="password" placeholder="请输入密码">
                                    </div>
                                    <div class="form-group">
                                        <div class="custom-control custom-checkbox small">
                                            <input type="checkbox" class="custom-control-input" id="customCheck">
                                            <label class="custom-control-label" for="customCheck">Remember Me</label>
                                        </div>
                                    </div>
                                    
                                    <button id="submitBtn" type="button" class="btn btn-primary btn-user btn-block">登录</button>
                                    <hr>
                                </form>
                                <hr>
                                <div class="text-center">
                                    <a class="small" href="/register">注册账号!</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    //jQuery代码
    //初始化
    $(function () {
        if(window != top){
            top.location.href = location.href;
        }
        $("#submitBtn").click(function () {
                $.ajax({
                    url:'/user/login', //请求地址
                    type:'POST', //请求类型
                    data:{
                        //账号密码
                        userAccount:$("#userAccount").val(),
                        password:$("#password").val()
                    }, //数据
                    dataType:'json', //数据类型
                    success:function (res){
                        if(res.code==20000){
                            layer.msg(res.msg)
                            window.sessionStorage.setItem("user",JSON.stringify(res.list))
                            //跳转
                            setTimeout(function (){
                                window.location.href='/main';
                            },1000)
                        }
                        else{
                            layer.msg(res.msg)
                        }
                    }
                })
        })
    })
</script>
</body>
</html>