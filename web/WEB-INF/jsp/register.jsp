<%--
  Created by IntelliJ IDEA.
  User: Specter
  Date: 2019/11/18
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <link rel="stylesheet" type="text/css" href="/css/index.css">
</head>
<body>
    <%
if (session.getAttribute("pass")!=null)
{
  String pass=(String) session.getAttribute("pass");
    %>
<script>alert("<%=pass%>");</script>
    <%
}
%>
<body>
<div class="column">
    <h2 class="header">
        用户注册
    </h2>
    <form name="form" action="${pageContext.request.contextPath}/hi/add" method="post">
        <div style="margin-top:25px;position:relative;">
            <input name="username" id="login_name" value="" type="text" class="txt" required="true" placeholder="请输入用户名">
        </div>
        <div style="margin-top:25px;position: relative;">
            <input name="password1" id="login_password1" value="" class="txt" type="password" required="true" maxlength="16" minlength="8" placeholder="请输入密码">
        </div>
        <div style="margin-top:25px;position: relative;">
            <input name="password2" id="login_password2" value="" class="txt" type="password" required="true" maxlength="16" minlength="8" placeholder="请确认密码">
        </div>
        <div id="login"  style="margin-top: 25px">
            <input class="button" type="submit" value="立即注册" />
        </div>
        <div class="xxx">
            已有账号？<a href="${pageContext.request.contextPath}/" style="color: darkturquoise;text-decoration:none;">登录</a>
        </div>
    </form>
</div>

</body>
</html>
