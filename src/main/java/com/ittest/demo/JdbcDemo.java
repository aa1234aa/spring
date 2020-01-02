package com.ittest.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 程序的藕合
 */

public class JdbcDemo {
    public static void main(String[] args)throws Exception{
        //注册驱动
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //获取连接
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy?useUnicode=true&characterEncoding=utf8","root","root");
        //获取操作数据库的预处理
        PreparedStatement pstm=conn.prepareStatement("select * from account");

        //执行sql.得到结果单
        ResultSet rs=pstm.executeQuery();
        //遍历结果集
        while (rs.next()){
            System.out.println(rs.getString("name"));
        }
        //释放资源
        rs.close();
        pstm.close();
        conn.close();
    }
}
