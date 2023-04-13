<%--
  Created by IntelliJ IDEA.
  User: 憨憨
  Date: 2023-04-10
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <title>注册页面</title>

    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        <%--提交前进行非空的校验--%>
        $(function (){
            var form=document.getElementById("myRegister");
            //添加submit事件监听器
            form.addEventListener("submit",function(event){
                //取消表单默认提交行为
                event.preventDefault();
                var username = document.getElementById("username").value;
                var password = document.getElementById("password").value;
                var phone = document.getElementById("phone").value;

                //校验用户名和密码是否非空
                if(username.trim()===""){
                    alert("用户名不能为空");
                    return;
                }
                if(password.trim()===""){
                    alert("密码不能为空");
                    return;
                }
                if(phone.trim()===""){
                    alert("手机号不能为空");
                    return;
                }

                //校验通过，提交表单
                form.submit();
            });

            <%--使用ajax进行用户名是否存在的判断--%>
            $("#username").blur(function () {
                //获取username文本输入框的值
                var username = $(this).val();
                <%--获取单选框里面的用户类别，根据类别去对应的表查询，看用户名是否存在--%>
                var status = document.querySelector('input[name="status"]:checked').value;
                //发送ajax请求
                $.get("/MyUbisoft/findUserServlet?"+$.param({username:username,status:status}),
                    function(data){
                        if(data==="true"){
                            //用户名存在username
                            alert("用户名存在");
                            $("#username").val("");
                        }
                });
            });

            <%--对两次输入的密码进行校验--%>
            $("#password2").blur(function () {
                let password=document.getElementById("password").value;

                let password2=document.getElementById("password2").value;
                if (password!==password2){
                    alert("两次密码不一致");
                    $("#password").val("");
                    $("#password2").val("");
                }
            });
        })
    </script>
</head>

<body style="background-color: #9acfea;">
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">请填写你的信息</h3>
    <%--进行登录验证--%>
    <form action="${pageContext.request.contextPath}/register" method="post" id="myRegister">
        <div class="form-group">
            <label for="username">用户名：</label>
            <input type="text" name="username" class="form-control" id="username" placeholder="请输入用户名"/>
        </div>

        <div id="checkpassword">
            <div class="form-group">
                <label for="password">密码：</label>
                <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
            </div>

            <div class="form-group">
                <label for="password2">确认密码：</label>
                <input type="password" name="password2" class="form-control" id="password2" placeholder="请输入密码"/>
            </div>
        </div>

        <div class="form-group">
            <label for="phone">电话号码：</label>
            <input type="text" name="phone" class="form-control" id="phone" placeholder="请输入密码"/>
        </div>

        <hr/>
        账户类型:<input type="radio" name="status" value="1">普通用户
        <input type="radio" name="status" value="2" checked="checked">会员

        <div class="form-group" style="text-align: center;">
            <input class="btn btn btn-primary" type="submit" value="注册">
            <a class="btn btn btn-primary" href="${pageContext.request.contextPath}/zwy/login.jsp">返回</a>
        </div>
    </form>

</div>
</body>
</html>
