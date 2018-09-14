<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>查询页</title>

    <!-- Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="icon" href="https://v3.bootcss.com/favicon.ico">

</head>
<body>
<div class="container">
    <h1>欢迎
        <small>${sessionScope.name}</small>
        登录!!
    </h1>
    <a href="success" class="btn btn-primary btn-lg active" role="button">首页</a>
    <a href="off" class="btn btn-default btn-lg active" role="button">退出</a>
    <hr>
    <table class="table table-striped">
        <thead>
        <tr>
            <td>ID</td>
            <td>账号名</td>
            <td>密码</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="u">
            <tr>
                <td>${u.id }</td>
                <td>${u.name }</td>
                <td>${u.password }</td>
                <td>
                    <a href="updateGet?id=${u.id}">修改</a>
                    <a href="delete?id=${u.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.bootcss.com/jquery/1.8.3/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
