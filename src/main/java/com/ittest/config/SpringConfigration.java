package com.ittest.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/*
* 配置类   和bean.xml一样
* 新注解
* @Configration   配置类
* ComponenScan   指定spring要扫描的包  value   和 basePackages一样 都是用来创建指定扫描的包  等同于xml配置
* <context:component-scan base-package="com.ittest"></context:component-scan>
*Bean 用于把当前方法的返回值作为bean对象存入spring的ioc容器中  name用于指定bean的id   当不写时，默认值是当前方法的名称  和AitoWrite一样的
*
*
*
* */
@Configuration
@ComponentScan("com.ittest")
public class SpringConfigration {
    @Bean(name = "runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }
    @Bean(name = "dataSource")
    public DataSource createDataSource(){
        try {
            ComboPooledDataSource ds=new ComboPooledDataSource();
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/eesy?serverTimezone=UTC");
            ds.setUser("root");
            ds.setPassword("root");
            return ds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
