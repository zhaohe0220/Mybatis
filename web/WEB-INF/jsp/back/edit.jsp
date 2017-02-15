<%--
  Created by IntelliJ IDEA.
  User: yunfei
  Date: 2017/2/15
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="<%=basePath%>update.action" method="post">
        <table>
            <tr>
                <td><input type="hidden" name="id" value="${message.id}"></td>
            </tr>
            <tr>
                <td>指令：</td>
                <td><input type="text" name="command" value="${message.command}"></td>
            </tr>
            <tr>
                <td>描述：</td>
                <td><input type="text" name="description" value="${message.description}"></td>
            </tr>
            <tr>
                <td>内容：</td>
                <td><input type="text" name="content" value="${message.content}"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="提交">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
