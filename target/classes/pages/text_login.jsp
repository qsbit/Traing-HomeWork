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
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/style.css">
    <script src="/static/js/jquery.js"></script>
</head>
<body>
    <div class="login-box">
        <h1>Login</h1>
        <div class="textbox">
            <i class="fa fa-user" aria-hidden="true"></i>
            <%-- 用户名--%>
            <input type="text" id="userName" placeholder="UserName" name="" value="">
        </div>

        <div class="textbox">
            <i class="fa fa-lock" aria-hidden="true"></i>
            <%-- 密码--%>
            <input type="password" id="password" placeholder="Password" name="" value="">
        </div>
        <button class="btn" id="loginBtn" type="button" >登录</button>
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
                    if(res.code==20000) {
                        alert("code：" + res.code + "\n" + "msg：" + res.msg + "\n" + "data："
                            + res.data + "\n" + "用户名：" + res.userName + "\n" + "密码：" + res.password)
                    }else{
                        alert(res.msg)
                    }
                }
            })
        })
    })
</script>
</body>
</html>