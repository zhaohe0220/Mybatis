package com.mybatis.servlet;

import com.mybatis.bean.Message;
import com.mybatis.service.QueryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by yunfei on 2017/2/14.
 * 列表页面初始化
 */
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String command = req.getParameter("command");
        String description = req.getParameter("description");
        req.setAttribute("command",command);
        req.setAttribute("description",description);
        QueryService QueryService = new QueryService();
        List<Message> messageList = QueryService.queryMessageList(command,description);
        req.setAttribute("messageList",messageList);
        req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
