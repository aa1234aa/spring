package com.ittest.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*创建bean对象的工厂
* Bean在计算机英语中，有可重用组件的含义
* javabean》实体类
* */

public class BeanFactory {
//定义一个propertie对象

    private static Properties props;
    //定义1个Map，来存放我们创建的对象 ，我们把它称为容器
    private static Map<String, Object> beans;

    //使用静态代码块为peoperties对象赋值
    static {
        try {
//实例化对象

            props = new Properties();
            //获取properties文件的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中所有的key
            Enumeration keys = props.keys();
            //遍历枚举
            while (keys.hasMoreElements()) {
                //取出每个key
                String key = keys.nextElement().toString();
                //根据key 取value
                String beanPath = props.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入到容器中
                beans.put(key, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("初始化失败");
        }
    }

//根据bean的名称获取bean对象

    public static Object getBean(String beanName) {
  /*  Object bean=null;
    try {
        String beanPath=props.getProperty(beanName);
        bean=Class.forName(beanPath).newInstance();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return bean;*/
        return beans.get(beanName);
}


}

