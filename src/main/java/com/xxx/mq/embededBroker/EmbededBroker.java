package com.xxx.mq.embededBroker;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import java.net.URI;

public class EmbededBroker {

    public static void main(String[] args) throws Exception {
        BrokerService brokerService = BrokerFactory.createBroker(
                new URI("xbean:src/main/resources/mqConfiguration/broker1App.xml"));
        brokerService.start();
    }
}
