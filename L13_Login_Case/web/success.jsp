<%@ page import="cn.study.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: Harlan
  Date: 2020/7/16
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
<h1>登录成功！</h1>
<h2>
    <%
        User user = (User) request.getAttribute("user");
        out.print(user.getUsername());
    %>
    ,欢迎您！
</h2>
</body>
</html>
