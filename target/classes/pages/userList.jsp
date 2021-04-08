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
        .reference th {
            color: #fff;
            background-color: #555;
            border: 1px solid #555;
            font-size: 12px;
            padding-left: 10px;
            padding-top: 7px;
            padding-bottom: 7px;
            vertical-align: top;
            text-align: left;
            width: 100px;
        }
        .reference td {
            line-height: 2em;
            min-width: 24px;
            border: 1px solid #d4d4d4;
            padding-left: 10px;
            padding-top: 7px;
            padding-bottom: 7px;
            vertical-align: top;
        }

        /*搜索框样式*/
        .search h1{
            margin: 0 0 10px;
            padding: 0;
            font-size: 24px;
        }


        .search label{
            font-size: 20px;
        }
        .search input{
            /*position: relative;*/
            display: inline-block;
            font-size: 20px;
            box-sizing: border-box;
            transition: 5s;
        }
        .search input[type="text"]{
            background: #fff;
            width: 340px;
            height: 40px;
            border: 1px solid slategray;
            outline: none;
            padding: 0 25px;
            border-radius: 25px 0 0 25px;
        }
        .search input[type="submit"]{
            /*position: relative;*/
            left: -5px;
            height: 40px;
            width: 100px;
            border-radius: 0 25px 25px 0;
            border: none;
            outline: none;
            cursor: pointer;
            background: #8b8b8b;
            color: #fff;
        }
        .search input[type="submit"]:hover{
            background: #85144b;
        }
    </style>
</head>
<body style="padding: 20px; background-color: #F2F2F2;">


<div class="layui-card layui-card-body">
    <div class="content">
        <div class="layui-form">
            <table class="layui-table">
                <colgroup>
                    <col width="150">
                    <col width="150">
                    <col width="200">
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>账号</th>
                    <th>密码</th>
                    <th>姓名</th>
                    <th>年龄</th>
                    <th>性别</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
    <%--                    el表达式--%>
                        <td>${user.id}</td>
                        <td>${user.userAccount}</td>
                        <td>${user.password}</td>
                        <td>${user.userName}</td>
                        <td>${user.age}</td>
                        <td>${user.gender}</td>
                        <td>
                            <button type="button" userid="${user.id}" useraccount="${user.userAccount}" username="${user.userName}" password="${user.password}" age="${user.age}" gender="${user.gender}" class="layui-btn layui-btn-primary layui-btn-sm edit"><i class="layui-icon layui-icon-edit "></i></button>
                            <button type="button" userid="${user.id}"  class="layui-btn layui-btn-primary layui-btn-sm delete"><i class="layui-icon layui-icon-delete"></i></button>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function (){
        //编辑
        $(".edit").click(function (){
                var userId = $(this).attr("userid");
                var userAccount = $(this).attr("useraccount");
                var userName = $(this).attr("username");
                var password = $(this).attr("password");
                var age = $(this).attr("age");
                var gender = $(this).attr("gender");

            layui.use('layer', function(){
                var layer = layui.layer;

                layer.open({
                    title: '编辑',
                    area:['500px','600px'],
                    btn: ['确定', '取消'],
                    shadeClose:true,
                    content:'<form style="margin-right: 25px;margin-top: 30px" class="layui-form"  href="javascript:void(0)">' +
                                '<div class="layui-form-item ">' +
                                    '<label class="layui-form-label">账号：</label>' +
                                    '<div class="layui-input-block">' +
                                        '<input type="text" disabled placeholder="请输入名称" id="userAccount" class="layui-input" value='+userAccount+'>' +
                                    '</div>' +
                                '</div>'+
                                '<div class="layui-form-item ">' +
                                '<label class="layui-form-label">姓名：</label>' +
                                '<div class="layui-input-block">' +
                                '<input type="text"  placeholder="请输入名称" id="userName" class="layui-input" value='+userName+'>' +
                                '</div>' +
                                '</div>'+
                                '<div class="layui-form-item ">' +
                                    '<label class="layui-form-label">密码：</label>' +
                                    '<div class="layui-input-block">' +
                                    '   <input type="text"  placeholder="请输入名称" id="password" class="layui-input" value='+password+'>' +
                                    '</div>' +
                                '</div>'+
                                '<div class="layui-form-item ">' +
                                    '<label class="layui-form-label">年龄：</label>' +
                                    '<div class="layui-input-block">' +
                                    '   <input type="text"  placeholder="请输入名称" id="age" class="layui-input" value='+age+'>' +
                                    '</div>' +
                                '</div>'+
                                '<div class="layui-form-item ">' +
                                    '<label class="layui-form-label">性别：</label>' +
                                    '<div class="layui-input-block">' +
                                    '   <input type="text"  placeholder="请输入名称" id="gender" class="layui-input" value='+gender+'>' +
                                    '</div>' +
                                '</div>'+
                            '</form>',

                    yes: function(index, layero){
                        var userAccount = $("#userAccount").val();
                        var userName = $("#userName").val();
                        var password = $("#password").val();
                        var age = $("#age").val();
                        var gender = $("#gender").val();

                        $.ajax({
                            url:'/user/changeInfo', //请求地址
                            type:'POST', //请求类型
                            data:{
                                //账号密码
                                userAccount:userAccount,
                                userName:userName,
                                password:password,
                                age:age,
                                gender:gender
                            }, //数据
                            dataType:'json', //数据类型
                            success:function (res){
                                if(res.code==20000){
                                    //提示信息
                                    layer.msg(res.msg)
                                    //列表刷新
                                    setTimeout(function (){
                                        window.location.reload();
                                    },2000)

                                }else if(res.code==50001){
                                    window.location.href = '/login'
                                }
                                else{
                                    layer.msg(res.msg)
                                }
                            }
                        })
                    },
                    btn2: function(index, layero){

                    }
                });
            });
        });

        //删除
        $(".delete").click(function (){
            layui.use('layer', function(){
                var layer = layui.layer;
                layer.open({
                    title: '删除',
                    area: ['200px', '200px'],
                    btn: ['确定', '取消'],
                    shadeClose:true,
                    content: '确定删除吗？',
                    yes: function(index, layero){
                        $.ajax({
                            url:'/deleteBtn', //请求地址
                            type:'POST', //请求类型
                            data:{
                                userId:$(this).attr("userid")
                            }, //数据
                            dataType:'json', //数据类型
                            success:function (res){
                                layer.msg(res.msg)
                                setTimeout(function (){
                                    window.location.reload();
                                },2000)
                            }
                        })
                    },
                    btn2: function(index, layero){

                    }
                })
            });
        })
    })



</script>

</body>
</html>