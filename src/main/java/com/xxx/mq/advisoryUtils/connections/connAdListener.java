package com.xxx.mq.advisoryUtils.connections;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQMessage;
import org.apache.activemq.command.ConnectionInfo;
import org.apache.activemq.command.DataStructure;
import org.apache.activemq.command.RemoveInfo;

import javax.jms.*;

public class connAdListener implements MessageListener {

    @Override
    public void onMessage(Message m) {
        try {
            //org.apache.activemq.advisory.AdvisorySupport.getConsumerAdvisoryTopic();
            ActiveMQMessage message = (ActiveMQMessage) m;
            DataStructure data = (DataStructure) message.getDataStructure();
            if (data.getDataStructureType() == ConnectionInfo.DATA_STRUCTURE_TYPE) {
                ConnectionInfo connectionInfo = (ConnectionInfo) data;
                System.out.println("Connection started: " + connectionInfo);
            } else if (data.getDataStructureType() == RemoveInfo.DATA_STRUCTURE_TYPE) {
                RemoveInfo removeInfo = (RemoveInfo) data;
                System.out.println("Connection stopped: " + removeInfo.getObjectId());
            } else {
                System.err.println("Unknown message " + data);
            }
            message.acknowledge();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
