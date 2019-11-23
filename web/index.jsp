<%--
  Created by IntelliJ IDEA.
  User: Specter
  Date: 2019/11/18
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>登录首页</title>
  <link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
<%
    session.setAttribute("pass",null);

if (session.getAttribute("error")!=null)
{
  String error=(String) session.getAttribute("error");
    %>
        <script>alert("<%=error%>");</script>
    <%
}
session.setAttribute("error",null);

      if (session.getAttribute("success")!=null)
      {
        String success=(String) session.getAttribute("success");
    %>
<script>alert("<%=success%>");</script>
<%
  }
  session.setAttribute("success",null);
%>
<div class="column">
  <h2 class="header">
    用户登录
  </h2>
  <form action="${pageContext.request.contextPath}/hi/login" method="post">
    <div style="margin-top:25px;position:relative;">
      <input name="username" id="login_name" value="" type="text" class="txt" required="true" placeholder="请输入用户名">
    </div>
    <div style="margin-top:25px;position: relative;">
      <input name="password" id="login_password" value="" class="txt" type="password" maxlength="16" minlength="8" required="true" placeholder="请输入密码">
    </div>
    <div id="login"  style="margin-top: 25px">
      <input class="button" type="submit" value="立即登录" />
    </div>
    <div class="xxx">
      未注册？<a href="${pageContext.request.contextPath}/hi/register" style="color: darkturquoise;text-decoration:none;">注册</a>
    </div>
  </form>
</div>
</body>
</html>