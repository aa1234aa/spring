package com.ittest.service.impl;


import com.ittest.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*业务层实现类*/
public class AccountServiceImpl2 {

    @Test
    public void testFindAll(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as=ac.getBean("accountService",IAccountService.class);

    }
    @Test
    public void testFindOne(){

    }
    @Test
    public void testSave(){

    }
    @Test
    public void testUpdate(){

    }
    @Test
    public void testDelete(){

    }
}
