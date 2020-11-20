package com.xxx.mq.spring.brokers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class broker1 {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext
                ("brokerApps/broker1App.xml");
        context.getBean("broker1");
    }
}
