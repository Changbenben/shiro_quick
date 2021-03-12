<%@page contentType="text/html; URF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>用户注册</title>

</head>
<body>
    <h1>用户注册</h1>
    <form action="${pageContext.request.contextPath}/user/regist" method="post">
        用户名:<input type="text" name="username"> <br/>
        密  码:<input type="text" name="password"> <br/>
        <input type="submit" value="注册"></input>
    </form>
</body>
</html>