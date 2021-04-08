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
    <link rel="stylesheet" href="https://www.layuicdn.com/layui/css/layui.css"  media="all">
    <style type="text/css">
        .layui-form-label{
            padding: 9px 0;
        }
        .myInput{
            padding: 10px 40% 10px 0;
        }
        .myDiv{
            margin: 20px 0 0 20px;
        }
        .myTable{
            margin: 20px 40% 0 20px;
        }
        .reference{
            border-collapse: collapse;
            width: 100%;
            margin-bottom: 4px;
            margin-top: 4px;
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
        .downIcon{
            font-size: 30px;
        }
        .downIcon:hover{
            color: #009688;
        }
    </style>
</head>
<body>
<div class="myDiv">
    <h2>hello ${hello}</h2>
</div>


<div class="myDiv">
    <a href="/toUpload"><button type="button" class="layui-btn">upload>>></button></a>
</div>

<div class="myTable">
    <table  class="reference">
        <tr>
            <th>id</th>
            <th>文件名</th>
            <th width="50px">下载</th>
        </tr>
        <c:forEach items="${files}" var="file">
            <tr>
                <td> ${file.id}</td>
                <td> ${file.fileName}</td>
                <td><a href="/downloadById/${file.id}"><i class="layui-icon layui-icon-download-circle downIcon"></i> </a></td>
            </tr>

        </c:forEach>
    </table>
</div>

<form class="layui-form" action="/download">
    <div class="layui-form-item">
        <div class="myInput">
            <label class="layui-form-label">文件名</label>
            <div class="layui-input-block">
                <input type="text" name="fileName" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
            </div>
        </div>
        <div class="myInput">
            <label class="layui-form-label">上传路径</label>
            <div class="layui-input-block">
                <input type="text" value="E:\springbootUpload" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
            </div>
        </div>
        <div class="myInput">
            <label class="layui-form-label">存储路径</label>
            <div class="layui-input-block">
                <input type="text" name="fileSqlPath" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                    <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">下载</button>
            </div>
        </div>
    </div>
</form>



<script src="https://www.layuicdn.com/layui/layui.js" charset="utf-8"></script>
<script>

</script>
</body>
</html>