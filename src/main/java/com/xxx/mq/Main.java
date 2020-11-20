package com.xxx.mq;

import com.xxx.mq.config.AMQConfig;
import com.xxx.mq.factory.AMQConnectionFactory;
import com.xxx.mq.myPool.MyPool;
import com.xxx.mq.publisher.MessageSendReceiveAndReply;
import com.xxx.mq.publisher.topicPublisher;
import com.xxx.mq.subscriber.MyReceiver;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import javax.jms.*;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

public class Main {


    static org.slf4j.Logger log = LoggerFactory.getLogger("Main.class");
    public static void main(String[] args) throws JMSException, InterruptedException, IOException {

        for (int i = 0; i < 12; ++i) {
            new Thread(() -> {
                Connection connection = AMQConnectionFactory.getConnection();
                try {

                    connection.start();
                    System.out.println(Thread.currentThread().getName() + "连接");
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        System.in.read();
    }

    @Test
    public void send() throws JMSException, InterruptedException {
        MessageSendReceiveAndReply messageSendReceiveAndReply = new MessageSendReceiveAndReply();
        messageSendReceiveAndReply.send("ds");
        //messageSendReceiveAndReply.sendMultiple();
        //topicPublisher t = new topicPublisher();
        //t.sendDurable();

    }

    @Test
    public void receive() throws JMSException {

        MyReceiver myReceiver = new MyReceiver();
        myReceiver.url2Receive(AMQConfig.queue);

        //myReceiver.RetroactiveCousumerReceive(AMQConnectionFactory.getConnection(), AMQConfig.topic);
        //myReceiver.RetroactiveCousumerReceive(AMQConnectionFactory.getConnection(), AMQConfig.topic);
        //myReceiver.RetroactiveCousumerReceive(AMQConnectionFactory.getConnection(), AMQConfig.topic);
    }
}
