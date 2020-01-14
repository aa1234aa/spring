package com.ittest.utils;

import java.sql.SQLException;

/*
* 和事务相关的工具类，包含开启事务，提交事务，回滚事务，释放事务
* */
public class TransactionManager {
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }
    /*开启事务*/
    public void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /*提交事务*/
    public void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /*回滚事务*/
    public void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /*释放事务*/
    public void release(){
        try {
            connectionUtils.getThreadConnection().close();/*还回线程池*/
            connectionUtils.removeConnection();//解绑
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
