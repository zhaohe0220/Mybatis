package com.mybatis.service;

import com.mybatis.bean.Command;
import com.mybatis.bean.CommandContent;
import com.mybatis.bean.Message;
import com.mybatis.dao.CommandDao;
import com.mybatis.dao.MessageDao;
import com.mybatis.entity.Page;
import com.mybatis.util.Iconst;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by yunfei on 2017/2/14.
 */
public class QueryService {
    public List<Message> queryMessageList(String command, String description, Page page){
        MessageDao messageDao = new MessageDao();
        int totalNumber = messageDao.count();
        page.setTotalNumber(totalNumber);
        Message message = new Message();
        message.setCommand(command);
        message.setDescription(description);
        Map<String,Object> parameter = new HashMap<String,Object>();
        parameter.put("message",message);
        parameter.put("page",page);
        return messageDao.queryMessageList(parameter);
    }

    public String queryByCommand(String command){
        CommandDao commandDao = new CommandDao();
        List<Command> queryCommandList = commandDao.queryCommandList(command,null);
        if(queryCommandList.size()>0){
            List<CommandContent> contentList = queryCommandList.get(0).getContentList();
            return contentList.get(new Random().nextInt(contentList.size())).getContent();
        }
        return Iconst.NO_MATCH_CONTENT;
    }
}
