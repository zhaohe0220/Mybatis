package com.mybatis.service;

import com.mybatis.bean.Message;
import com.mybatis.dao.MessageDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunfei on 2017/2/14.
 */
public class MaintainService {
    public void deleteOne(String id){
        if(id!=null&&!"".equals(id.trim())){
            MessageDao messageDao = new MessageDao();
            messageDao.deleteOne(Integer.valueOf(id));
        }
    }

    public void deleteBatch(String[] ids){
        MessageDao messageDao = new MessageDao();
        List<Integer> list = new ArrayList<>();
        for (String id:ids){
            list.add(Integer.valueOf(id));
        }
        messageDao.deleteBatch(list);
    }

    public void insert(Message message){
        MessageDao messageDao = new MessageDao();
        messageDao.insert(message);
    }

    public Message selectById(String id){
        Message message=null;
        if(id!=null&&!"".equals(id.trim())){
            MessageDao messageDao = new MessageDao();
            message = messageDao.selectById(Integer.valueOf(id));
        }
        return message;
    }

    public void update(Message message){
        MessageDao messageDao = new MessageDao();
        /*if(id!=null&&!"".equals(id.trim())){
            message.setId(Integer.valueOf(id));
        }*/
        messageDao.update(message);
    }

}
