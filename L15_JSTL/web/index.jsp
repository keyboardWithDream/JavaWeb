<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.study.domain.User" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  User: Harlan
  Date: 2020/7/17
  Time: 14:48
--%>
<html>
  <head>
    <title>JSTL标签</title>
  </head>
  <body>
  <%
    List<Integer> list = new ArrayList<>();
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    list.add(50);
    request.setAttribute("list", list);

    request.setAttribute("num", 3);

    List<User> users = new ArrayList<>();
    users.add(new User("张三",28,"男",new Date(1997-11-17)));
    users.add(new User("李四",22,"男",new Date(1992-3-12)));
    users.add(new User("王五",21,"男",new Date(2000-7-31)));
    request.setAttribute("users", users);
  %>

  <!-- c:if 标签 -->
  <c:if test="true">
    <h1>Hello JSTL!</h1>
  </c:if>

  <hr>

  <!-- c:choose 标签 -->
  <c:choose>
    <c:when test="${num == 1}">星期一</c:when>
    <c:when test="${num == 2}">星期二</c:when>
    <c:when test="${num == 3}">星期三</c:when>
    <c:when test="${num == 4}">星期四</c:when>
    <c:when test="${num == 5}">星期五</c:when>
    <c:when test="${num == 6}">星期六</c:when>
    <c:when test="${num == 7}">星期日</c:when>
    <c:otherwise>值异常</c:otherwise>
  </c:choose>

  <hr>

  <!-- c:forEach 标签 -->
  <c:forEach begin="0" end="9" var="i" step="1">
    ${i}&nbsp;
  </c:forEach>

  <br>

  <c:if test="${not empty list}">
    <c:forEach items="${list}" var="num" varStatus="s">
      <span style="color: red">第${s.count}个元素：</span>${num}&nbsp;&nbsp;
    </c:forEach>
  </c:if>

  <br>

  <table style="border: 1px solid red">
    <caption>用户信息表</caption>
    <tr>
      <th>用户名</th>
      <th>年龄</th>
      <th>性别</th>
      <th>出生日期</th>
    </tr>
    <c:if test="${not empty users}">
      <c:forEach items="${users}" var="user">
        <tr>
          <td>${user.name}</td>
          <td>${user.age}</td>
          <td>${user.sex}</td>
          <td>${user.birthday}</td>
        </tr>
      </c:forEach>
    </c:if>
  </table>
  </body>
</html>
