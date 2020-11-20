package com.xxx.mq.config;

public class AMQConfig {

    public static String url2 = "failover:(tcp://158.220.153.216:50001)";
    // 加上wireFormat.tightEncodingEnable=false 可以降低cpu载荷
    public static String url = "failover:(tcp://127.0.0.1:60001?wireFormat.tightEncodingEnabled=false)";
    public static String url3 = "failover:(tcp://158.220.153.216:60001)";

    public static String queue = "STOCKS.JAVA";

    public static String replyToQueue = "replyTo.nonHaQueue";

    public static String topic = "testSize";

    public static String temQueue = "TemQueue";



}
