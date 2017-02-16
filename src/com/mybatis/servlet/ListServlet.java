package com.mybatis.servlet;

import com.mybatis.bean.Message;
import com.mybatis.entity.Page;
import com.mybatis.service.QueryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

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
        String currentPage = req.getParameter("currentPage");
        Page page = new Page();
        Pattern pattern = Pattern.compile("[0-9]{1,9}");
        if(currentPage == null || !pattern.matcher(currentPage).matches()){
            page.setCurrentPage(1);
        }else {
            page.setCurrentPage(Integer.valueOf(currentPage));
        }
        QueryService QueryService = new QueryService();
        List<Message> messageList = QueryService.queryMessageList(command,description,page);
        req.setAttribute("messageList",messageList);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
