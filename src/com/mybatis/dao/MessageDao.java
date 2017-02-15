package com.mybatis.dao;

import com.mybatis.bean.Message;
import com.mybatis.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunfei on 2017/2/14.
 */
public class MessageDao {

    /*public List<Message> queryMessageList(String command,String description) {
        List<Message> messageList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mybatis?useUnicode=true&characterEncoding=utf-8","root","root");
            StringBuilder sql = new StringBuilder("select id,command,description,content from message where 1=1");
            List<String> paramList = new ArrayList<>();
            if(command!=null&&!"".equals(command.trim())){
                sql.append(" and command = ?");
                paramList.add(command);
            }
            System.out.println(sql);
            if(description!=null&&!"".equals(description.trim())){
                sql.append(" and description = ?");
                paramList.add(description);
            }
            PreparedStatement statement = conn.prepareStatement(sql.toString());
            for (int i = 0;i<paramList.size();i++){
                statement.setString(i+1,paramList.get(i));
            }
            System.out.println(sql.toString());
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Message message = new Message();
                messageList.add(message);
                message.setId(rs.getInt("id"));
                message.setCommand(rs.getString("command"));
                message.setDescription(rs.getString("description"));
                message.setContent(rs.getString("content"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messageList;
    }*/

    public List<Message> queryMessageList(String command, String description) {
        DBAccess dbAccess = new DBAccess();
        List<Message> messageList = new ArrayList<>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            Message message = new Message();
            message.setCommand(command);
            message.setDescription(description);
            //执行sql;
            messageList = sqlSession.selectList("Message.find",message);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
        return messageList;
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

    public void insert(Message message){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.insert("Message.insert",message);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    public Message selectById(Integer id){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        Message message = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            message = sqlSession.selectOne("Message.selectById",id);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
        return message;
    }

    public void update(Message message){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.update("Message.update",message);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }

}
