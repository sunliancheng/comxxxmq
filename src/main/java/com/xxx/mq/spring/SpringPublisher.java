package com.xxx.mq.spring;

import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;
import java.util.HashMap;

public class SpringPublisher {

    private JmsTemplate template;
    private int count = 10;
    private int total;
    private Destination[] destinations;
    private HashMap<Destination, MyMessageCreator>
            creators = new HashMap<>();
    
    public void start() {
        while (total < 1000) {
            for (int i = 0; i < count; ++i) {
                sendMessage();
            }
            total += count;
            if (count % 100 == 0)
                System.out.println("published " + count + " of " + total + " price messages ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected void sendMessage() {
        int idx = 0;
        while (true) {
            idx = (int)Math.round(destinations.length * Math.random());
            if (idx < destinations.length) {
                break;
            }
        }
        Destination destination = destinations[idx];
        template.send(destination, getStockMessageCreator(destination));
    }
    private MyMessageCreator getStockMessageCreator(Destination dest) {
        if (creators.containsKey(dest)) {
            return creators.get(dest);
        } else {
            MyMessageCreator creator = new MyMessageCreator(dest);
            creators.put(dest, creator);
            return creator;
        }
    }

    public Destination[] getDestinations() {
        return destinations;
    }

    public HashMap<Destination, MyMessageCreator> getCreators() {
        return creators;
    }

    public JmsTemplate getTemplate() {
        return template;
    }

    public int getCount() {
        return count;
    }

    public int getTotal() {
        return total;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setCreators(HashMap<Destination, MyMessageCreator> creators) {
        this.creators = creators;
    }

    public void setTemplate(JmsTemplate template) {
        this.template = template;
    }

    public void setDestinations(Destination[] destinations) {
        this.destinations = destinations;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
