package com.mybatis.dao;

import com.mybatis.bean.Message;

import java.util.List;

/**
 * Created by yunfei on 2017/2/16.
 */
//与message配置相对应的接口
public interface IMessage {
    public List<Message> find(Message message);

}
