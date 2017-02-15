package com.mybatis.service;

import com.mybatis.bean.Command;
import com.mybatis.bean.CommandContent;
import com.mybatis.dao.CommandDao;
import com.mybatis.util.Iconst;
import com.mybatis.bean.Message;
import com.mybatis.dao.MessageDao;

import java.util.List;
import java.util.Random;

/**
 * Created by yunfei on 2017/2/14.
 */
public class QueryService {
    public List<Message> queryMessageList(String command,String description){
        MessageDao messageDao = new MessageDao();
        return messageDao.queryMessageList(command,description);
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
