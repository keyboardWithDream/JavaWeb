<%@ page import="jakarta.servlet.ServletContext" %>
<%@ page import="cn.study.domain.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  User: Harlan
  Date: 2020/7/17
  Time: 13:27
--%>
<html>
<head>
    <title>El获取数据</title>
</head>
<body>
<%
    //存储值
    request.setAttribute("msg", "Hello EL!");
    session.setAttribute("msg", "Hello World!");
    //存储对象
    User user = new User("harlan", 23, new Date());
    request.setAttribute("user", user);
    //存储List集合
    List<Integer> list = new ArrayList<>();
    list.add(0);
    list.add(1);
    list.add(2);
    request.setAttribute("list", list);
    //存储Map集合
    Map<String, Object> map = new HashMap<>();
    map.put("name", "harlan");
    map.put("age", 23);
    map.put("sex", "男");
    request.setAttribute("map", map);
%>
<h3>获取值</h3>
${requestScope.msg}<br>
${sessionScope.msg}<br>
${msg}
<hr>
<h3>获取对象的值</h3>
${user.name}<br>
${user.age}<br>
${user.birthdayStr}
<hr>
<h3>获取List元素</h3>
${list}<br>
${list[0]}
${list[1]}
${list[2]}
<hr>
<h3>获取Map集合</h3>
${map}<br>
${map.name}<br>
${map.age}<br>
${map.sex}
</body>
</html>
