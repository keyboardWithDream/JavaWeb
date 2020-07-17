<%--
  User: Harlan
  Date: 2020/7/16
  Time: 19:22
--%>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" language="java" %>
<html>
<head>
    <title>500</title>
</head>
<body>
<h1>服务器正忙...</h1>
<%
    String eMessage = exception.getMessage();
    out.print(eMessage);
%>
</body>
</html>