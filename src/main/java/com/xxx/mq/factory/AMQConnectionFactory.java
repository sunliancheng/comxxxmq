package com.xxx.mq.factory;

import com.xxx.mq.config.AMQConfig;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.JMSException;

public class AMQConnectionFactory {

    private static ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(AMQConfig.url);

    public static Connection getConnection() {
        try {

            return factory.createConnection();
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return null;
    }

}
