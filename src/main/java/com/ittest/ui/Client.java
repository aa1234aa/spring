package com.ittest.ui;

import com.ittest.dao.IAcountDao;
import com.ittest.factory.BeanFactory;
import com.ittest.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*模拟一个表现层，用于调用业务层*/
public class Client {
    public static void main(String[] args) {
       // IAccountService as=new AccountServiceImpl();
/*        for (int i=0;i<5;i++){
            IAccountService as= (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }*/
        /*获取核心容器对象*/
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        /*根据id获取bean对象*/
        IAccountService as=(IAccountService) ac.getBean("accountService");
        IAcountDao adao=ac.getBean("accountDao",IAcountDao.class);
        System.out.println(as);
        System.out.println(adao);
    }
}
