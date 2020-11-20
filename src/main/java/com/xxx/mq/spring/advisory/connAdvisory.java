package com.xxx.mq.spring.advisory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class connAdvisory {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext
                ("advisory/connAdvisory.xml");
        //context.getBean("connAdvisory");
    }
}
