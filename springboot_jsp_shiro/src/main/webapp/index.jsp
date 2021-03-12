<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@page contentType="text/html; URF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>系统主页</title>
</head>
<body>
    <h1>hello,shiro</h1>

    <shiro:hasAnyRoles name="user,admin">
        <li><a href="">用户管理</a></li>
        <ul>
            <shiro:hasPermission name="user:add:*">
                <li>添加</li>
            </shiro:hasPermission>
            <shiro:hasPermission name="user:delete:*">
                <li>删除</li>
            </shiro:hasPermission>
            <shiro:hasPermission name="user:update:*">
                <li>更改</li>
            </shiro:hasPermission>
            <shiro:hasPermission name="user:find:*">
                <li>查找</li>
            </shiro:hasPermission>
        </ul>
    </shiro:hasAnyRoles>



    <shiro:hasRole name="admin">
        <li><a href="">商品管理</a></li>
        <li><a href="">订单管理</a></li>
        <li><a href="">物流管理</a></li>
    </shiro:hasRole>

</body>
</html>