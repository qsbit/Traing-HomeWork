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
    <style type="">
        .myDiv{
            margin: 20px 0 0 20px;
        }
    </style>
</head>
<body>

<%--    <form action="/upload" enctype="multipart/form-data" method="post">--%>
<%--        <input type="file" name="file">--%>
<%--        <br/>--%>
<%--        <input type="submit" value="上传">--%>
<%--    </form>--%>


<%--    <form action="/download">--%>
<%--        文件名<input type="text" name="fileName"><br/>--%>
<%--        文件上传路径<input type="text" value="E:\springbootUpload"><br/>--%>
<%--        文件存储路径<input type="text" name="fileSqlPath">--%>
<%--        <input type="submit" name="下载">--%>
<%--    </form>--%>

    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
        <legend>选完文件后不自动上传</legend>
    </fieldset>

    <div class="layui-upload myDiv" >
        <button type="button" class="layui-btn layui-btn-normal" id="test8">选择文件</button>
        <button type="button" class="layui-btn" id="test9">开始上传</button>
    </div>


    <div class="myDiv">
        <a href="/toDownload"><button type="button" class="layui-btn">download>>></button></a>
    </div>

    <script src="https://www.layuicdn.com/layui/layui.js" charset="utf-8"></script>
    <script>
        layui.use('upload', function() {
            var $ = layui.jquery
                , upload = layui.upload;
            //选完文件后不自动上传
            upload.render({
                elem: '#test8'
                , url: '/upload' //改成您自己的上传接口
                , auto: false
                //,multiple: true
                , bindAction: '#test9'
                , done: function (res) {
                    layer.msg('上传成功');
                    console.log(res)
                }
            });
        })
    </script>
</body>
</html>