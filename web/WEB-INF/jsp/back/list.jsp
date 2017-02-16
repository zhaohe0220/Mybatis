<%--
  Created by IntelliJ IDEA.
  User: yunfei
  Date: 2017/2/14
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>List</title>
    <script src="<%=basePath%>resources/js/jquery-3.1.1.min.js"></script>
    <script src="<%=basePath%>resources/js/list.js"></script>
</head>
<body>
<h4>${error}</h4>
    <form action="<%=basePath%>List.action" method="post" id="mainForm">
        <table>
            <tr>
                <td>指令名称：</td>
                <td>
                    <input type="text" name="command" value="${command}">
                </td>
                <td>描述：</td>
                <td>
                    <input type="text" name="description" value="${description}">
                </td>
                <td><input type="submit" value="查询"></td>
            </tr>
        </table>

        <table>
            <tr>
                <th>选择</th>
                <th>序号</th>
                <th>指令名称</th>
                <th>描述</th>
                <th colspan="2">操作</th>
            </tr>
            <c:forEach items="${messageList}" var="message" varStatus="status">
                <tr <c:if test="${status.index % 2 != 0}"> style="background-color: #ECF6EE" </c:if>>
                    <td><input type="checkbox" name="id" value="${message.id}"></td>
                    <td>${status.index + 1}</td>
                    <td>${message.command}</td>
                    <td>${message.description}</td>
                    <td>
                        <a href="${basePath}DeleteOneServlet.action?id=${message.id}">删除</a>
                    </td>
                    <td>
                        <a href="${basePath}editMessage.action?id=${message.id}">编辑</a>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td>
                   <a href="javascript:deleteBatch('<%=basePath%>');">批量删除</a>
                </td>
                <td>
                    <a href="<%=basePath%>addMessage.action">添加信息</a>
                </td>
            </tr>
        </table>
        <div>
            <input type="hidden" name="currentPage" id="currentPage" value="${page.currentPage}">
            共${page.totalNumber}条记录<br>
            <c:if test="${page.currentPage != 1}">
                <a href="javascript:changeCurrentPage('1')">首页</a>
                <a href="javascript:changeCurrentPage(${page.currentPage - 1})">上一页</a>
            </c:if>
            当前${page.currentPage}/${page.totalPage}页
            <c:if test="${page.currentPage != page.totalPage}">
                <a href="javascript:changeCurrentPage(${page.currentPage + 1})">下一页</a>
                <a href="javascript:changeCurrentPage(${page.totalPage})">尾页</a>
            </c:if>
        </div>
    </form>



</body>
</html>
