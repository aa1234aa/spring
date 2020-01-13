package com.ittest.config;


import org.springframework.context.annotation.*;

/*
* 配置类   和bean.xml一样
* 新注解
* @Configration   配置类
* ComponenScan   指定spring要扫描的包  value   和 basePackages一样 都是用来创建指定扫描的包  等同于xml配置
* <context:component-scan base-package="com.ittest"></context:component-scan>
*Bean 用于把当前方法的返回值作为bean对象存入spring的ioc容器中  name用于指定bean的id   当不写时，默认值是当前方法的名称  和AitoWrite一样的
*import 用于导入其他配置类的字节码
*PropertySource 用于指定propertie文件的位置
*
* */
@PropertySource("classpath:jdbcConfig.properties")
@Configuration
@ComponentScan("com.ittest")
@Import(JdbcConfig.class)
public class SpringConfigration {

}
