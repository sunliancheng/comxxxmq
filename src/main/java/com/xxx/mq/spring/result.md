## 消息回流问题
消息回流开启后，双向网桥会一直来回传送，即使设置了messageTTL，并且持久化消息未签收的时候，重启broker会丢消息

## 性能优化
两个broker之间可以有多个connector，因为每个connector都是单transport connection，如果负载很重，多个connectors可以提升性能
至少512mb 来维持1000+connections

## tight encoding
OpenWire 格式，关闭 tight encoding，可以提升性能
tcp://localhost:60001?wireFormat.tightEncodingEnabled=false

## policyEntry
对于很多Queues，这很建议开启 optimizedDispatch.
当开启replyWhenNoConsumer的时候，可能会导致消息堆积在其中一台机器上，而不是来回流动.消息能从A-B，而不是B-A
如下所示，把optimized放到 第一个entry中，就能正常流动
<policyEntries>
    <policyEntry queue=">" optimizedDispatch="true">
        <networkBridgeFilterFactory>
            <conditionalNetworkBridgeFilterFactory replayWhenNoConsumers="true"/>
        </networkBridgeFilterFactory>
    </policyEntry>

    <!--<policyEntry queue=">" optimizedDispatch="false"/>-->
</policyEntries>


## 超过最大连接数：
WARN | Could not accept connection : Exceeded the maximum number of allowed client connections. See the 'maximumConnections' property on the TCP transport configuration URI in the ActiveMQ configuration file (e.g., activemq.xml) (Exceeded the maximum number of allowed client connections. See the 'maximumConnections' property on the TCP transport configuration URI in the ActiveMQ configuration file (e.g., activemq.xml))
一个consumer producer算是一个connection，网桥之间不算入connection

## 发送多个目的地
Queue ordersDestination = session.createQueue("store.orders, store.orders2");

## Advisory Messages
Connection, Destination, Consumer, Producer 加入或离开broker会产生Advisory Message
当达到broker系统限制的时候,会产生警告消息

Advisory有以下属性:
* originBrokerId
* originBrokerName
* originBrokerURL



## Todo list
如何监听 advisory.consumer











