package com.mybatis.bean;

/**
 * Created by yunfei on 2017/2/15.
 */
public class CommandContent {
    private Integer id;
    private String content;
    private Integer commandId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCommandId() {
        return commandId;
    }

    public void setCommandId(Integer commandId) {
        this.commandId = commandId;
    }
}
