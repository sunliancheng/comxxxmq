package com.xxx.mq.publisher;

import com.xxx.mq.config.AMQConfig;
import com.xxx.mq.factory.AMQSessionFactory;

import javax.jms.*;

public class topicPublisher {

    public int count = 0;

    public void send() throws JMSException {
        Session session = AMQSessionFactory.getSession(false, Session.CLIENT_ACKNOWLEDGE);
        Topic topic = session.createTopic(AMQConfig.queue);
        MessageProducer messageProducer = session.createProducer(topic);
        TextMessage textMessage = session.createTextMessage("ddd");
        messageProducer.send(textMessage);
    }

    public void sendDurable() throws JMSException {
        Session session = AMQSessionFactory.getSession(false, Session.CLIENT_ACKNOWLEDGE);

        Topic topic = session.createTopic(AMQConfig.topic);
        MessageProducer messageProducer = session.createProducer(topic);
        messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
        TextMessage textMessage = session.createTextMessage("ddd");
        messageProducer.send(textMessage);
    }

}
