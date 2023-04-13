<%--
  Created by IntelliJ IDEA.
  User: 憨憨
  Date: 2023-04-12
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.dao.Mybatis.pojo.Comment" %>
<%@ page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>评论区</title>
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <style type="text/css">
        #div1{
            float: left;
            width: 70%;
            margin-left: 20%;
        }
    </style>

</head>
<body style="margin: auto; background-color: #f5e79e">
    <div id="div1">
        <table border="1" >
            <tr >
                <th>用户名</th>
                <th>评论</th>
            </tr>

            <%--使用jstl对所有评论进行查询--%>
            <c:forEach items="${allComment}" var="comment" varStatus="status">
                <tr>
                    <td>${comment.username}</td>
                    <td style="width: 600px;">
                        ${comment.textComment}<br>
                        <c:if test="${comment.picture!=null}">
                          <img src="${pageContext.request.contextPath}/img/commentImg/${comment.picture}" style="width: 200px">
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <%--用户在这里进行评论--%>
        <div>
            <form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
                <input type="file" name="fileUpload"><br>
                <textarea name="textComment" style="width: 350px;height: 70px" placeholder="请输入评论"></textarea><br>
                <input type="submit" value="评论">
            </form>
        </div>

    </div>
</body>
</html>
