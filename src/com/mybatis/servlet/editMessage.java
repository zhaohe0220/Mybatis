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
public class editMessage extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        MaintainService maintainService = new MaintainService();
        Message message = maintainService.selectById(id);
        req.setAttribute("message",message);
        req.getRequestDispatcher("/WEB-INF/jsp/back/edit.jsp").forward(req,resp);
    }
}
