<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>用户登录页面</title></head>
<body>
<h1>用户登录页面</h1>
<a style="color: red">${msg}</a>
<form action="/login" method="post">
    用户名称:<input type="text" name="username"/><br/>
    用户密码:<input type="text" name="password"/><br/>
    <input type="submit" value="submit">
</form>
</body>
</html>