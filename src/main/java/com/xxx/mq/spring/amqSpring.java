package com.xxx.mq.spring;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.jms.pool.PooledConnectionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class amqSpring {


    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext
                ("application.xml");
        //context.getBean("broker1");
    }

    @Test
    public void broker1() {
        ApplicationContext context = new ClassPathXmlApplicationContext
                ("brokerApps/broker1App.xml");
        context.getBean("broker1");
    }

    @Test
    public void broker2() {
        ApplicationContext context = new ClassPathXmlApplicationContext
                ("brokerApps/broker2App.xml");
        context.getBean("broker2");
    }

}
