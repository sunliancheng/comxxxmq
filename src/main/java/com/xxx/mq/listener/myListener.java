package com.xxx.mq.listener;

import org.apache.activemq.command.ActiveMQMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.Enumeration;
import java.util.Vector;

public class myListener implements MessageListener {

    @Override
    public void onMessage(Message message) {

        try {
            System.out.println("listener1 " + " messages " + message.toString());
            //message.acknowledge();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
