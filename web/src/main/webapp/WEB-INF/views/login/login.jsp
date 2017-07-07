<%--
  Created by IntelliJ IDEA.
  User: y64195
  Date: 2017/7/3
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../base/base.jsp"%>
    <base href="<%=basePath%>"/>
</head>
<body>
    <h1>this is my first shrio project</h1>
    <form name="loginForm" id="loginForm" action="loginSubmit" method="get">
        <label>userName</label><input id="userName" name="userName">
        <label>passWord</label><input type="password" id="passWord" name="passWord">
        <div>
            <input type="submit" value="submit">
        </div>
    </form>
</body>
</html>
