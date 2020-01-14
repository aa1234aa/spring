package com.ittest.cglib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*模拟一个消费者
* 动态代理
* 特点：字节码随用随创建，随用随加载
* 作用：不修改源码的基础上对方法增强
* 分类：基于接口的   基于子类的
* 基于接口的动态代理
* 涉及的类：proxy
* 如何创建代理对象
* 使用proxy类中的newProxyInstance
* 创建代理对象的要求
* 被代理类至少实现一个接口，如果没有就不能使用
* newProxyInstance方法的参数
*     classloader 类加载器
*     加载代理对象字节码的，写的是被代理对象的类加载器
*   InvocationHandler
* */
public class Client {
    public static void main(String[] args) {
        //被匿名内部类访问用final
        final Producer producer=new Producer();
        IProcucer proxyProcucer=(IProcucer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),producer.getClass().getInterfaces() ,new InvocationHandler(){
            /**
             * @Title:  invoke
             * @Description: 执行被代理对象的任何接口方法都会经过该方法
             * @param: 代理对象的引用
             * @param: 当前执行的方法
             * @param: 当前执行方法需要的参数
             * @return: 和被代理对象有相同的返回值
             * @date: 2020/1/14 18:03
             * @throws   Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强的代码
                Object returnValue=null;
                //获取方法执行的参数
                Float money=(Float)args[0];
                //判断当前方法是不是销售
                if ("saleProduct".equals(method.getName())){
                    returnValue=method.invoke(producer,money*0.8f);
                }
               return returnValue;
            }
        });
        proxyProcucer.saleProduct(1000f);
    }
}

