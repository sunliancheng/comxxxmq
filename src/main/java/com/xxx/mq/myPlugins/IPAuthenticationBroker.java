package com.xxx.mq.myPlugins;

import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerFilter;
import org.apache.activemq.broker.ConnectionContext;
import org.apache.activemq.command.ConnectionInfo;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAuthenticationBroker extends BrokerFilter {

    List<String> allowedIPAddresses;
    Pattern pattern = Pattern.compile("^/([0-9\\.]*):(.*)");

    public IPAuthenticationBroker(Broker next, List<String> allowedIPAddresses) {
        super(next);
        this.allowedIPAddresses = allowedIPAddresses;
    }

    public void addConnection(ConnectionContext context, ConnectionInfo info)
            throws Exception {
        String remoteAddress = context.getConnection().getRemoteAddress().split(":")[1].substring(2);

        if (!allowedIPAddresses.contains(remoteAddress))
            throw new SecurityException("Connecting IP: " + remoteAddress + "is not allowed");
        super.addConnection(context, info);
    }

}
