<%--
  Created by IntelliJ IDEA.
  User: yunfei
  Date: 2017/2/14
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>
    <a href="<%=basePath%>List.action">进入</a>
  </h1>
  </body>
</html>
