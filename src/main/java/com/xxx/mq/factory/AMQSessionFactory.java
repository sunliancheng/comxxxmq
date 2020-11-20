package com.xxx.mq.factory;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;

public class AMQSessionFactory {

    public static Session getSession(boolean arg1, int arg2) {
        Connection connection = AMQConnectionFactory.getConnection();

        try {
            connection.start();
            return connection.createSession(arg1, arg2);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return null;
    }
}
