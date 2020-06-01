<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>功能展示页面</title></head>
<body>
<h1>springboot整合shiro</h1>
<shiro:guest>
    您当前是游客，<a href="/toLogin">点击登录</a>
</shiro:guest>

<shiro:user>
    欢迎[<shiro:principal property="username"/>]登录，<a href="/logout">退出</a>
</shiro:user>

<hr/>
<a href="/toAdd">用户添加功能</a><br/>
<a href="/toUpdate">用户更新功能</a><br/>

<hr/>
<!----------------------------------------------------------------------->
<shiro:hasPermission name="user:add">
    用户[<shiro:principal property="username"/>]，你具有添加权限
</shiro:hasPermission>
<shiro:hasPermission name="user:update">
    用户[<shiro:principal property="username"/>]，你具有更新权限
</shiro:hasPermission>

<!----------------------------------------------------------------------->
<shiro:lacksPermission name="user:add">
    你没有添加权限
</shiro:lacksPermission>
<shiro:lacksPermission name="user:update">
    你没有更新权限
</shiro:lacksPermission>
</body>
</html>