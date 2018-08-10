package cn.itcast.crm.test.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.crm.service.impl.CustomerService;

public class CustomerServiceTest {
    
    @Test
    public void findAllTest(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-service.xml");
        CustomerService customerService = (CustomerService)ac.getBean("customerService");
        
        System.out.println(customerService.findAll().size());
    }
}
