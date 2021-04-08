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
    <title>注册</title>
    <link href="/static/css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body class="bg-gradient-primary">

<div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
                <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                <div class="col-lg-7">
                    <div class="p-5">
                        <div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4">创建账号!</h1>
                        </div>
                        <form class="user">
                            <div class="form-group">
                                <input type="text" class="form-control form-control-user" id="regist_account" name="regist_account" placeholder="注册账号">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control form-control-user" id="regist_name" name="regist_name" placeholder="注册用户名">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control form-control-user" id="regist_tel" name="regist_tel" placeholder="注册手机号">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control form-control-user" id="regist_pwd" name="regist_pwd" placeholder="注册密码">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control form-control-user" id="regist_pwd_con" name="regist_pwd_con" placeholder="确认密码">
                            </div>
                            <button type="submit" class="btn btn-primary btn-user btn-block" id="registsubmit" onclick="javascript:regist()">注册</button>
                            <hr>
                        </form>
                        <hr>
                        <div class="text-center">
                            <a class="small" href="/login">已有账号? 登录!</a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>