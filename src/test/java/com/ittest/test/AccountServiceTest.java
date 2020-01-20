package com.ittest.test;

import com.ittest.config.JdbcConfig;
import com.ittest.config.SpringConfigration;
import com.ittest.domain.Account;
import com.ittest.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfigration.class)
public class AccountServiceTest {
    private ApplicationContext ac;
    @Autowired
    @Qualifier("proxyAccountService")
    private IAccountService as;
    @Before
   public void init(){
       //获取容器
       //ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        ac=new AnnotationConfigApplicationContext(SpringConfigration.class);
       //得到业务层对象
        as=ac.getBean("accountService",IAccountService.class);
   }
    @Test
    public void testFindAll(){

        //执行方法
        List<Account> accounts=as.findAllAccount();
        for (Account account:accounts){
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne(){
        //执行方法
       Account  account=as.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void testSave(){
        Account account=new Account();
        account.setName("test");
        account.setMoney(1.222f);
        //执行方法
        as.saveAccount(account);
    }
    @Test
    public void testUpdate(){
        //执行方法
        Account account=as.findAccountById(4);
        account.setName("anan");
        as.updateAccount(account);
    }
    @Test
    public void testDelete(){
        //执行方法
        as.deleteAccount(6);
    }
    @Test
    public void testTransfer(){
        as.transfer("aaa","bbb",10f);
    }


}
