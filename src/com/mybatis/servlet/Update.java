package com.mybatis.servlet;

import com.mybatis.bean.Message;
import com.mybatis.service.MaintainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yunfei on 2017/2/15.
 */
public class Update extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        String command = req.getParameter("command");
        String description = req.getParameter("description");
        String content = req.getParameter("content");
        Message message = new Message();
        message.setId(Integer.valueOf(id));
        message.setCommand(command);
        message.setDescription(description);
        message.setContent(content);
        MaintainService maintainService = new MaintainService();
        maintainService.update(message);
        req.getRequestDispatcher("/List.action").forward(req,resp);
    }
}
