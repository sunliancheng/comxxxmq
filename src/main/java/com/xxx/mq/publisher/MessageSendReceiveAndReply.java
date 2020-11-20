package com.xxx.mq.publisher;


import com.xxx.mq.config.AMQConfig;
import com.xxx.mq.factory.AMQConnectionFactory;
import com.xxx.mq.factory.AMQSessionFactory;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQPrefetchPolicy;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;

import javax.jms.*;
import java.util.Date;

public class MessageSendReceiveAndReply {

    public void send(String text) throws JMSException {

        Date date = new Date();
        long t = date.getTime();

        final Session session = AMQSessionFactory.getSession(false, 4);
        Queue queue = session.createQueue(AMQConfig.queue);
        Message message = session.createTextMessage(text);
        MessageProducer messageProducer = session.createProducer(queue);
        messageProducer.send(message);

        date = new Date();
        t = date.getTime() - t;
        if (t > 10)
            System.out.println(t);

    }

    public void prefetchSend(String text) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(AMQConfig.url2);
        ActiveMQPrefetchPolicy policy = new ActiveMQPrefetchPolicy();
        policy.setAll(0);
        activeMQConnectionFactory.setPrefetchPolicy(policy);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        final Session session = AMQSessionFactory.getSession(false, Session.CLIENT_ACKNOWLEDGE);
        Queue queue = session.createQueue(AMQConfig.queue);
        Message message = session.createTextMessage(text);
        MessageProducer messageProducer = session.createProducer(queue);
        messageProducer.send(message);
    }

    public void sendMultiple() throws JMSException {
        Session session = AMQSessionFactory.getSession(false, 4);
        Queue ordersDestination = session.createQueue("store.orders, store.orders2");
        MessageProducer producer = session.createProducer(ordersDestination);
        Message order = session.createObjectMessage();
        producer.send(order);
    }

}
