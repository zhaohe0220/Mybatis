<%--
  Created by IntelliJ IDEA.
  User: yunfei
  Date: 2017/2/15
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Talk</title>
    <script src="<%=basePath%>resources/js/jquery-3.1.1.min.js"></script>
    <script src="<%=basePath%>resources/js/talk.js"></script>
</head>
<body>
<input type="hidden" id="basePath" value="<%=basePath%>">
    <input type="text" id="content">
    <input type="submit" onclick="send();" value="发送">
</body>
</html>
