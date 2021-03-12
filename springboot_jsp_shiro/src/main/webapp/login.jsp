<%@page contentType="text/html; URF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>用户登录</title>
</head>
<body>
    <h1>用户登录</h1>
    <a href="${pageContext.request.contextPath}/user/logout">退出登录</a>
    <form action="${pageContext.request.contextPath}/user/login" method="post">
        用户名:<input type="text" name="username"> <br/>
        密  码:<input type="text" name="password"> <br/>
        <input type="submit" value="登录"></input>
    </form>


</body>
</html>