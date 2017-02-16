package com.mybatis.interceptor;

import com.mybatis.entity.Page;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

/**
 * Created by yunfei on 2017/2/16.
 */
@Intercepts({@Signature(type = StatementHandler.class,method = "prepare",args = {Connection.class})})
public class PageInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY,SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, null);
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        String id = mappedStatement.getId();
        if(id.matches(".+ByPage$")){
            BoundSql boundSql = statementHandler.getBoundSql();
            String sql = boundSql.getSql();//原始sql语句
            //查询总条数
            String countSql = "select count(*) from (" + sql+ ")a";
            Connection connection = (Connection) invocation.getArgs()[0];
            PreparedStatement countStatement = connection.prepareStatement(countSql);
            ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
            parameterHandler.setParameters(countStatement);
            ResultSet rs = countStatement.executeQuery();
            Map<?,?> parameter = (Map<?, ?>) boundSql.getParameterObject();
            Page page = (Page) parameter.get("page");
            if(rs.next()){
                page.setTotalNumber(rs.getInt(1));
            }
            String pageSql = sql + " limit " + page.getDbIndex() + "," + page.getDbNumber();
            metaObject.setValue("delegate.boundSql.sql",pageSql);
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
