<%--
  User: Harlan
  Date: 2020/7/17
  Time: 12:57
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>EL表达式</title>
  </head>
  <body>
  <h3>语法</h3>
  \${3 > 4}
  ${3 > 4}
  <hr>
  <h3>算数运算符</h3>
  \${3 + 4} --- ${3 + 4}<br>
  \${9 div 3} --- ${9 div 3}<br>
  \${9 mod 2} --- ${9 mod 2}
  <hr>
  <h3>逻辑运算符</h3>
  \${10 > 5 and 5 > 10} --- ${10 > 5 and 5 > 10}
  </body>
</html>
