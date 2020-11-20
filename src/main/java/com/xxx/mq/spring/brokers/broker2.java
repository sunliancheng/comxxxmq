package com.xxx.mq.spring.brokers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class  broker2 {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext
                ("brokerApps/broker2App.xml");
        context.getBean("broker2");
    }
}
