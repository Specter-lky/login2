<%--
  Created by IntelliJ IDEA.
  User: Specter
  Date: 2019/11/20
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
    <link rel="stylesheet" type="text/css" href="/css/index.css">
</head>
<body>
<%
    session.setAttribute("error",null);
%>
    <h2 style="text-align: center;">${status}</h2>
    <div style="text-align: center;">
        <a href="${pageContext.request.contextPath}/" style="text-align: center;color: darkturquoise;text-decoration:none;">退出登录</a>
    </div>
</body>
</html>
