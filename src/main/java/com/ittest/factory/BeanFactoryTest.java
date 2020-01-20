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
    private IAccountService accountService;
    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 获取service的代理对象
     * @return
     */
    public IAccountService getAccountService() {

        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {

            /**
             * 添加事务的支持
             *
             * @param proxy
             * @param method
             * @param args
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object rtvAlue = null;
                try {
                    //1.开启事务
                    txManager.beginTransaction();
                    //2.执行操作
                    rtvAlue = method.invoke(accountService, args);
                    //3.提交事务
                    txManager.commit();
                    //4.返回结果
                    return rtvAlue;
                } catch (Exception e) {
                    //5.回滚操作
                    txManager.rollback();
                    throw new RuntimeException(e);
                } finally {
                    //6.释放连接
                    txManager.release();
                }
            }
        });
    }
}
