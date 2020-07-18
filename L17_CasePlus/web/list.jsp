<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  User: Harlan
  Date: 2020/7/18
  Time: 13:53
--%>
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        function deleteUser(id) {
            if (confirm("确定删除吗?")) {
                location.href = "${pageContext.request.contextPath}/delete?id=" + id;
            }
        }

        window.onload = function () {
            document.getElementById("delUsers").onclick = function () {
                if (confirm("确定删除吗?")){
                    document.getElementById("form").submit();
                }
            }
        }
    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div style="float: left; margin: 5px">
        <form class="form-inline">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" class="form-control" id="exampleInputName2" name="name" maxlength="30" size="8"
                       placeholder="姓名">
            </div>
            <div class="form-group">
                <label for="gender">性别</label>
                <input type="text" class="form-control" id="gender" name="gender" maxlength="1" size="2"
                       placeholder="性别">
            </div>
            <div class="form-group">
                <label for="age">年龄</label>
                <input type="text" class="form-control" id="age" name="age" maxlength="3" size="3" placeholder="年龄">
            </div>
            <div class="form-group">
                <label for="address">籍贯</label>
                <input type="text" class="form-control" id="address" name="address" maxlength="10" size="5"
                       placeholder="籍贯">
            </div>
            <div class="form-group">
                <label for="qq">QQ号</label>
                <input type="text" class="form-control" id="qq" name="qq" maxlength="30" size="10" placeholder="QQ号">
            </div>
            <div class="form-group">
                <label for="email">邮箱</label>
                <input type="email" class="form-control" id="email" name="email" maxlength="30" size="15"
                       placeholder="邮箱">
            </div>
            <div class="form-group" style="text-align: center">
                <button type="submit" class="btn btn-default">查询</button>
            </div>
        </form>
    </div>
    <div style="float: right; margin: 5px">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加用户</a>
        <a class="btn btn-danger" href="javascript:void (0);" id="delUsers">删除选中</a>
    </div>
    <form id="form" action="${pageContext.request.contextPath}/delUsers" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th>选择</th>
                <th>ID</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th colspan="2">操作</th>
            </tr>
            <c:if test="${not empty page.list}">
                <c:forEach items="${page.list}" var="user">
                    <tr>
                        <td><input type="checkbox" name="ids" value="${user.id}"></td>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.gender}</td>
                        <td>${user.age}</td>
                        <td>${user.address}</td>
                        <td>${user.qq}</td>
                        <td>${user.email}</td>
                        <td>
                            <a class="btn btn-default" href="${pageContext.request.contextPath}/findUser?id=${user.id}" id="update">修改</a>
                        </td>
                        <td>
                            <a class="btn btn-danger" href="javascript:deleteUser(${user.id});" id="delete">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${empty page.list}">
                <tr>
                    <td colspan="9" align="center">目前暂无数据</td>
                </tr>
            </c:if>
        </table>
    </form>
    <div align="center">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${page.currentPage == 1}">
                    <li class="disabled">
                </c:if>
                <c:if test="${page.currentPage != 1}">
                    <li>
                </c:if>
                    <a href="${pageContext.request.contextPath}/userPage?currentPage=${page.currentPage-1}&rows=15" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach begin="1" end="${page.totalPage}" var="i">
                    <c:if test="${i == page.currentPage}">
                        <li class="active"><a href="${pageContext.request.contextPath}/userPage?currentPage=${i}&rows=15">${i}</a></li>
                    </c:if>
                    <c:if test="${i != page.currentPage}">
                        <li><a href="${pageContext.request.contextPath}/userPage?currentPage=${i}&rows=15">${i}</a></li>
                    </c:if>
                </c:forEach>

                <c:if test="${page.currentPage == page.totalPage}">
                    <li class="disabled">
                </c:if>
                <c:if test="${page.currentPage != page.totalPage}">
                    <li>
                </c:if>
                    <a href="${pageContext.request.contextPath}/userPage?currentPage=${page.currentPage+1}&rows=15" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 25px; margin-left: 30px">共${page.totalCount}条记录, 共${page.totalPage}页</span>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>