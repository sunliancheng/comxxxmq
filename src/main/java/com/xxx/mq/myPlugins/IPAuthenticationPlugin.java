package com.xxx.mq.myPlugins;

import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerPlugin;

import java.util.List;

public class IPAuthenticationPlugin implements BrokerPlugin {
    List<String> allowedIPAddresses;

    @Override
    public Broker installPlugin(Broker broker) throws Exception {
        return new IPAuthenticationBroker(broker, allowedIPAddresses);
    }

    public void setAllowedIPAddresses(List allowedIPAddresses) {
        this.allowedIPAddresses = allowedIPAddresses;
    }

    public List<String> getAllowedIPAddresses() {
        return allowedIPAddresses;
    }
}
