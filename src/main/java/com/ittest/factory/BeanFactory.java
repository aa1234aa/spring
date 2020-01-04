package com.ittest.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*创建bean对象的工厂
* Bean在计算机英语中，有可重用组件的含义
* javabean》实体类
* */
public class BeanFactory {
    /*定义一个propertie对象*/
    private static Properties props;

    //使用静态代码块为peoperties对象赋值
    static {
        try {
            /*实例化对象*/
            props = new Properties();
            //获取properties文件的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("初始化失败");
        }
    }
    /*根据bean的名称获取bean对象*/
    public static Object getBean(String beanName){
        Object bean=null;
        try {
            String beanPath=props.getProperty(beanName);
            bean=Class.forName(beanPath).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
