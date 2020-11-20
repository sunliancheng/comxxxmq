package com.xxx.mq.advisoryUtils.consumers;

import org.apache.activemq.advisory.AdvisorySupport;
import org.apache.activemq.command.ActiveMQMessage;
import org.apache.activemq.command.ConsumerInfo;
import org.apache.activemq.command.DataStructure;
import org.apache.activemq.command.RemoveInfo;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

public class ConsumerAdListener implements MessageListener {
    @Override
    public void onMessage(Message m) {
        try {
            //AdvisorySupport
            ActiveMQMessage message = (ActiveMQMessage) m;
            System.out.println("Consumer Count = " + m.getStringProperty("consumerCount"));
            DataStructure data = (DataStructure) message.getDataStructure();
            if (data.getDataStructureType() == ConsumerInfo.DATA_STRUCTURE_TYPE) {
                ConsumerInfo consumerInfo = (ConsumerInfo) data;
                System.out.println("Consumer started: " + consumerInfo);
            } else if (data.getDataStructureType() == RemoveInfo.DATA_STRUCTURE_TYPE) {
                RemoveInfo removeInfo = (RemoveInfo) data;
                System.out.println("Consumer stopped: " + removeInfo.getObjectId());
            } else {
                System.err.println("Unknown message " + data);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
