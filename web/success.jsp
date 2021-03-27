<%--
  Created by IntelliJ IDEA.
  User: leonwoo
  Date: 2020/3/5
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=basePath %>"/>
    <title>Title</title>
</head>
<body>
    <h1 align="center">恭喜您，成功转账</h1>

</body>
</html>
