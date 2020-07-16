<%--
  Created by IntelliJ IDEA.
  User: Harlan
  Date: 2020/7/16
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/l13/login" method="post">
    <label for="username">用户名:</label><input type="text" id="username" name="username" placeholder="请输入用户名">
    <label for="password">密&nbsp;&nbsp;&nbsp;码:</label><input type="password" id="password" name="password" placeholder="请输入密码">
    <img src="/l13/checkCode" id="checkCode" alt="验证码"><span>看不清？</span><a href="javascript:void(0);" id="changeCode">换一张</a>
    <label for="checkCode_input">验证码:</label><input type="text" id="checkCode_input" name="checkCode_input" maxlength="4" placeholder="请输入验证码">
    <input type="submit" value="提交">
    <p style="color: red" id="error"><%= request.getAttribute("error") == null ? "" : request.getAttribute("error")%></p>
</form>
</body>

<script>

    //切换验证码点击事件
    window.onload = function () {
        document.getElementById("changeCode").onclick = function () {
            document.getElementById("checkCode").src = "/l13/checkCode?"+new Date().getTime();
        }
        document.getElementById("checkCode").onclick = function () {
            this.src = "/l13/checkCode?"+new Date().getTime();
        }
    }
</script>
</html>
