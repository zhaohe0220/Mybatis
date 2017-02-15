package com.mybatis.dao;

import com.mybatis.bean.Command;
import com.mybatis.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunfei on 2017/2/14.
 */
public class CommandDao {

    public List<Command> queryCommandList(String command, String description) {
        DBAccess dbAccess = new DBAccess();
        List<Command> commandList = new ArrayList<>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            Command commands = new Command();
            commands.setCommand(command);
            commands.setDescription(description);
            //执行sql;
            commandList = sqlSession.selectList("Command.queryCommandList",commands);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
        return commandList;
    }

    public void deleteOne(int id){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            //执行sql;
            sqlSession.delete("Message.deleteOne",id);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }

    public void deleteBatch(List<Integer> ids){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            //执行sql;
            sqlSession.delete("Message.deleteBatch",ids);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }

}
