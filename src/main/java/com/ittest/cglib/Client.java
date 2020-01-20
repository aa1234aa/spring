package com.ittest.cglib;

import com.ittest.proxy.Producer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


/*模拟一个消费者
* 动态代理
* 特点：字节码随用随创建，随用随加载
* 作用：不修改源码的基础上对方法增强
* 分类：基于接口的   基于子类的
* 基于接口的动态代理
* 涉及的类：Enhancer    提供者第三方cglib库
* 如何创建代理对象
* 使用Enhancer类中的create方法
* 创建代理对象的要求
* 被代理类不能是最终类
* create方法的参数
*     class字节码
*     加载代理对象字节码的，写的是被代理对象的类加载器
*   callback 提供增强   我们一般写的是该接口的子接口的是实现类  MethodInterceptor
* */
public class Client {
    final static Producer producer=new Producer();
    public static void main(String[] args) {
        Producer cglibProducer=(Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             *
             * @param proxy
             * @param method
             * @param args
             * 以上3个参数和基于接口的动态代理中invoke方法是一样的
             * @param methodProxy 当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
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
        cglibProducer.saleProduct(12000f);
    }
}

