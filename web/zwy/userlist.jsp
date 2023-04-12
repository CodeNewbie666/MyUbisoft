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
    <script type="text/javascript">
        $(function (){
            <!--点击时，进行表单提交-->
            $("#select").click(function (){
                document.getElementById("from").submit();
            })
        })
    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>

    <div style="float: right;margin: 5px;">
        <a class="btn btn-primary" href="javascript:void(0)" id="select">删除选中</a>
    </div>

    <form action="${pageContext.request.contextPath}/deleteSelect" id="from">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox"></th>
                <th>id</th>
                <th>姓名</th>
                <th>密码</th>
                <th>号码</th>
                <th>类型</th>
            </tr>

            <%--使用jstl对所有用户进行查询--%>
            <c:forEach items="${pageBean.currentList}" var="user" varStatus="status">
                <tr>
                    <td><input type="checkbox" name="IdAndStatus" value="${user.id},${user.status}"></td>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>${user.phoneNumber}</td>
                    <td>${user.status}</td>
                    <td><a class="btn btn-default btn-sm"
                           href="${pageContext.request.contextPath}/zwy/changeuser.jsp?id=${user.id}&username=${user.username}
                           &password=${user.password}&phoneNumber=${user.phoneNumber}&status=${user.status}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/deleteUser?id=${user.id}&status=${user.status}">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>

    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach begin="1" end="${pageBean.maxPage}" var="i">
                    <%--当前页码高亮显示--%>
                    <c:if test="${pageBean.currentPage==i}">
                        <li class="active"><a href="${pageContext.request.contextPath}/userList?currentPage=${i}">${i}</a></li>
                    </c:if>
                    <c:if test="${pageBean.currentPage!=i}">
                        <li><a href="${pageContext.request.contextPath}/userList?currentPage=${i}">${i}</a></li>
                    </c:if>
                </c:forEach>

                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 25px;margin-left: 5px;">
                    共${pageBean.maxrow}记录，共${pageBean.maxPage}页
                </span>

            </ul>
        </nav>

    </div>

</div>

</body>
</html>
