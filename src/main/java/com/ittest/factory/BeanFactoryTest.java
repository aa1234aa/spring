package com.ittest.factory;

import com.ittest.service.IAccountService;
import com.ittest.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName BeanFactoryTest
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/1/20 15:02
 * @Version 1.0
 */
public class BeanFactoryTest {
    private  IAccountService accountService;
    private  TransactionManager txManger;

    public void setTxManger(TransactionManager txManger) {
        this.txManger = txManger;
    }

    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public IAccountService getAccountService() {
        Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(),
                new InvocationHandler() {
            /**
             * @param proxy
             * @param method
             * @param args
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object rtValue = null;
                try {
                    //开启事务
                    txManger.beginTransaction();
                    //执行操作
                    rtValue = method.invoke(accountService, args);
                    //提交事务
                    txManger.commit();
                    //返回结果
                    return rtValue;
                } catch (Exception e) {
                    //回滚
                    txManger.rollback();
                    throw new RuntimeException(e);
                } finally {
                    //释放连接
                    txManger.release();
                }
            }
        });
    }
}
