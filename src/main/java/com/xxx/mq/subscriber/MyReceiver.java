package com.xxx.mq.subscriber;

import com.xxx.mq.config.AMQConfig;
import com.xxx.mq.factory.AMQConnectionFactory;
import com.xxx.mq.factory.AMQSessionFactory;
import com.xxx.mq.publisher.MessageSendReceiveAndReply;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQPrefetchPolicy;
import org.junit.Test;

import javax.jms.*;

public class MyReceiver {

    public void receive(String queue) {
        Session session = AMQSessionFactory.getSession(false, Session.AUTO_ACKNOWLEDGE);
        try {
            MessageConsumer messageConsumer = session
                    .createConsumer(session.createQueue(queue));
            Message message = messageConsumer.receive();
            message.acknowledge();
            System.out.println(message);
        } catch (JMSException e) {
            e.printStackTrace();

        }
    }

    public void RetroactiveCousumerReceive(Connection connection, String queue) throws JMSException {

        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);

        try {
            String retroactive = "TEST.TOPIC?consumer.retroactive=true";

            MessageConsumer messageConsumer = session
                    .createConsumer(session.createTopic(retroactive));

            messageConsumer.setMessageListener((Message message) -> {
                System.out.println(message.toString());
                try {
                    message.acknowledge();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            });
            //messageConsumer.receive();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void url2Receive(String queue) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(AMQConfig.url2);
        ActiveMQPrefetchPolicy policy = new ActiveMQPrefetchPolicy();
        policy.setQueuePrefetch(0);
        activeMQConnectionFactory.setPrefetchPolicy(policy);
        Connection connection = activeMQConnectionFactory.createConnection();
        //connection.setClientID("myDurableID");
        connection.start(); MessageConsumer messageConsumer = null;
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        try {
            messageConsumer = session
                    .createConsumer(session.createQueue(queue));
            Message message = messageConsumer.receive();
            message.acknowledge();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            messageConsumer.close();
            session.close();
            connection.close();
        }
    }


}
