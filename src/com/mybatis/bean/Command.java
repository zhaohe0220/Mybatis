package com.mybatis.bean;

import java.util.List;

/**
 * Created by yunfei on 2017/2/15.
 */
public class Command {
    private Integer id;
    private String command;
    private String description;
    private List<CommandContent> contentList;

    public List<CommandContent> getContentList() {
        return contentList;
    }

    public void setContentList(List<CommandContent> contentList) {
        this.contentList = contentList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
