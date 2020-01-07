package com.ittest.ui;

import com.ittest.dao.IAcountDao;
import com.ittest.service.IAccountService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/*模拟一个表现层，用于调用业务层*/
/*核心容器两个接口
* Application 单例对象适用
*他在构建核心容器时，创建对象采取的策略是立即加载的方式，只要一读取文件马上就创建配置文件中的配置的对象
* BeanFactory  多例对象适用
* 他在构建核心容器时，创建对象采取的策略是采用延迟加载的方式，也就是说，什么时候根据id获取对象了，什么时候才真正的创建对象
* */
public class Client {
    public static void main(String[] args) {
       // IAccountService as=new AccountServiceImpl();
/*        for (int i=0;i<5;i++){
            IAccountService as= (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }*/
       // 获取核心容器对象
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
       // 根据id获取bean对象
        IAccountService as=(IAccountService) ac.getBean("accountService");
        //IAcountDao adao=ac.getBean("accountDao",IAcountDao.class);
        System.out.println(as);
       // System.out.println(adao);

        //beanFactory
     /*   Resource resource=new ClassPathResource("bean.xml");
        BeanFactory factory=new XmlBeanFactory(resource);
        IAccountService ass=(IAccountService) factory.getBean("accountService");
        System.out.println(ass);*/
    }
}
