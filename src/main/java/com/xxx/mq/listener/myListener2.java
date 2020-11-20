package com.xxx.mq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

public class myListener2 implements MessageListener {

    @Override
    public void onMessage(Message message) {

        System.out.println("listener2 " + " messages " + message.toString());
        try {
            //message.acknowledge();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}