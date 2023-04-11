<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>用户管理</title>

    <!-- 导入bootstrap和jquery-->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>

    <div style="float: right;margin: 5px;">
        <a class="btn btn-primary" href="add.html">删除选中</a>
    </div>

    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>密码</th>
            <th>号码</th>
            <th>操作</th>
        </tr>

       <%--使用jstl对所有用户进行查询--%>
        <c:forEach items="${allUsers}" var="user" varStatus="status">
            <tr>
                <td><input type="checkbox"></td>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.phoneNumber}</td>
                <td><a class="btn btn-default btn-sm"
                       href="${pageContext.request.contextPath}/zwy/changeuser.jsp?id=${user.id}&username=${user.username}&password=${user.password}&phoneNumber=${user.phoneNumber}">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/deleteUser?id=${user.id}">删除</a></td>
            </tr>
        </c:forEach>

    </table>

    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 25px;margin-left: 5px;">
                    共16条记录，共4页
                </span>

            </ul>
        </nav>


    </div>


</div>


</body>
</html>
