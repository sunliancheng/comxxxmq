package com.xxx.mq.spring.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class consumer1 {
        public static void main(String[] args) throws Exception {
            ApplicationContext context = new ClassPathXmlApplicationContext
                    ("consumer/consumer1.xml");
            //context.getBean("broker1");
        }

}
