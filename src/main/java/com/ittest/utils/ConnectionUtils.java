package com.ittest.utils;

import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/*连接的工具类，它用于从数据源中获取一个连接，实现和线程的绑定*/

public class ConnectionUtils {
   private ThreadLocal<Connection> tl=new ThreadLocal<Connection>();

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private DataSource dataSource;
   /*获取当前线程上的连接*/
    public Connection getThreadConnection(){
        Connection conn=tl.get();
        try {
            if (conn==null){
                conn=dataSource.getConnection();
                tl.set(conn);
            }
            return conn;

        } catch (Exception e) {
            throw new
                    RuntimeException(e);
        }
    }
    public void removeConnection(){
        tl.remove();
    }
}
