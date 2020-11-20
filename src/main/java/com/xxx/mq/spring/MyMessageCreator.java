package com.xxx.mq.spring;

import org.springframework.jms.core.MessageCreator;

import javax.jms.*;
import java.util.Hashtable;
import java.util.Map;

public class MyMessageCreator implements MessageCreator {

    private int MAX_DELTA_PERCENT = 1;
    private Map<Destination, Double> LAST_PRICE = new Hashtable<>();

    Destination stock;

    public MyMessageCreator(Destination stock) {
        this.stock = stock;
    }

    @Override
    public Message createMessage(Session session) throws JMSException {
        MapMessage message = session.createMapMessage();
        return message;
    }

    protected double mutatePrice(double price) {
        return price;
    }
}
