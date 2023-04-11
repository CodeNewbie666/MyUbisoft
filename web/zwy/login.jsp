<%--
  Created by IntelliJ IDEA.
  User: 李成俊
  Date: 2023-04-10
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <title>管理员登录</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        <%--提交前进行非空的校验--%>
        $(function (){
            var form=document.getElementById("myForm");
            //添加submit事件监听器
            form.addEventListener("submit",function(event){
                //取消表单默认提交行为
                event.preventDefault();
                var username = document.getElementById("username").value;
                var password = document.getElementById("password").value;

                //校验用户名和密码是否非空
                if(username.trim()===""){
                    alert("用户名不能为空");
                    return;
                }
                if(password.trim()===""){
                    alert("密码不能为空");
                    return;
                }
                //校验通过，提交表单
                form.submit();
            });
        })
    </script>
</head>

<body style="background-color: #9acfea;">
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">欢迎登录</h3>
    <%--进行登录验证--%>
    <form action="${pageContext.request.contextPath}/loginCheck" method="post" id="myForm">
        <div class="form-group">
            <label for="username">用户名：</label>
            <input type="text" name="username" class="form-control" id="username" placeholder="请输入用户名"/>
        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
        </div>
        账户类型: <input type="radio" name="status" value="0">管理员
                <input type="radio" name="status" value="1">普通用户
                <input type="radio" name="status" value="2" checked="checked">会员
        <hr/>
        <div class="form-group" style="text-align: center;">
            <input class="btn btn btn-primary" type="submit" value="登录">
            <a class="btn btn btn-primary" href="register.jsp">注册</a>
        </div>
    </form>

</div>
</body>
</html>