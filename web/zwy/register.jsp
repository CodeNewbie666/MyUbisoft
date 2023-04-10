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
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>管理员登录</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="../js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="../js/bootstrap.min.js"></script>
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

                //发送ajax请求
                $.get("/MyUbisoft/findUserServlet",{username:username},function (data) {
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
    <form action="/MyUbisoft/register" method="post" id="myRegister">
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
        <div class="form-group" style="text-align: center;">
            <input class="btn btn btn-primary" type="submit" value="注册">
        </div>
    </form>

</div>
</body>
</html>