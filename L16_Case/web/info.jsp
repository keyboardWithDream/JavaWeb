<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  User: Harlan
  Date: 2020/7/17
  Time: 18:57
--%>
<style>
    td {
        text-align: center;
    }
</style>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>信息显示</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->

    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <table class="table table-hover">
                <caption>用户信息表</caption>
                <thead>
                <tr>
                    <td>ID</td>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>年龄</td>
                    <td>地址</td>
                    <td>QQ</td>
                    <td>邮箱</td>
                    <td style="text-align: center" colspan="2">操作</td>
                </tr>
                </thead>
                <c:if test="${not empty users}">
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.gender}</td>
                            <td>${user.age}</td>
                            <td>${user.address}</td>
                            <td>${user.qq}</td>
                            <td>${user.email}</td>
                            <td><button type="button" class="btn btn-default" id="update">修改</button></td>
                            <td><button type="button" class="btn btn-danger" id="delete">删除</button></td>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${not empty user}">
                    <tr>
                        <td colspan="9">当前无数据</td>
                    </tr>
                </c:if>
                <tr>
                    <td colspan="9"><button type="button" class="btn btn-primary" id="insert">添加数据</button></td>
                </tr>
            </table>
        </div>
        <div class="col-md-1"></div>
    </div>
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4" id="insert_div" style="display: none">
            <form class="form-horizontal" action="${pageContext.request.contextPath}/insert" method="post">
                <div class="form-group">
                    <label for="exampleInputName2">姓名</label>
                    <input type="text" class="form-control" id="exampleInputName2" name="name" maxlength="30" size="15" placeholder="姓名">
                </div>
                <div class="form-group">
                    <label for="gender">性别</label>
                    <input type="text" class="form-control" id="gender" name="gender" maxlength="1" size="2" placeholder="性别">
                </div>
                <div class="form-group">
                    <label for="age">年龄</label>
                    <input type="text" class="form-control" id="age" name="age" maxlength="3" size="3" placeholder="年龄">
                </div>
                <div class="form-group">
                    <label for="address">地址</label>
                    <input type="text" class="form-control" id="address" name="address" maxlength="30" size="15" placeholder="地址">
                </div>
                <div class="form-group">
                    <label for="qq">QQ号</label>
                    <input type="text" class="form-control" id="qq" name="qq" maxlength="30" size="15" placeholder="QQ号">
                </div>
                <div class="form-group">
                    <label for="email">邮箱</label>
                    <input type="email" class="form-control" id="email" name="email" maxlength="30" size="15" placeholder="邮箱">
                </div>
                <div class="form-group" style="text-align: center">
                    <button type="submit" class="btn btn-default">添加</button>
                    <button type="button" class="btn btn-default" id="close">关闭</button>
                </div>
            </form>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
<script>
    <c:if test="${isSuccess == true}">
    alert("添加成功！");
    </c:if>
    window.onload = function () {
        document.getElementById("insert").onclick = function () {
            document.getElementById("insert_div").style.display = "";
            document.getElementById("close").onclick = function () {
                document.getElementById("insert_div").style.display = "none"
            }
        }
    }
</script>
</html>
