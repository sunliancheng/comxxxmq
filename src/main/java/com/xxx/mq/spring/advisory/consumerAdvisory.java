package com.xxx.mq.spring.advisory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class consumerAdvisory {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext
                ("advisory/consumerAdvisory.xml");
        //context.getBean("connAdvisory");
    }
}
