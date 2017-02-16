package com.mybatis.dao;

import com.mybatis.bean.Message;

import java.util.List;
import java.util.Map;

/**
 * Created by yunfei on 2017/2/16.
 */
//与message配置相对应的接口
public interface IMessage {
    public List<Message> find(Map<String,Object> parameter);

    public void insertBatch(List<Message> messages);

    public int count();

    public void deleteOne(int id);

    public void deleteBatch(List<Integer> ids);

    public void insert(Message message);

    public Message selectOne(int id);

    public void update(Message message);

}
