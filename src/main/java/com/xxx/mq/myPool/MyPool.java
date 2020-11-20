package com.xxx.mq.myPool;

import com.xxx.mq.factory.AMQConnectionFactory;

import javax.jms.Connection;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyPool {

    public static List<Object> connPool = new LinkedList<>();
    //public static Map<String, Object> connPool2 = new HashMap<>();

    private static Lock lock = new ReentrantLock();

    public MyPool() {


        if (connPool == null) {
            init();
            System.out.println("******    It is null and initializing......    ******");
        }

        for (int i = 0; i < MyPoolConfig.INIT_CONNECTION; ++i) {
            try {
                Connection conn = AMQConnectionFactory.getConnection();
                connPool.add(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    public static void init() {


    }

    public Connection getConnectionPool() {
        Connection conn = null;

        lock.lock();
        try {
            if (connPool.size() <= 0) {
                throw new Exception("run out of the connections");
            } else {
                conn = (Connection) connPool.remove(0);
            }
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return conn;
    }

    public void releaseConnection(Connection conn) {
        if (conn != null) {
            lock.lock();
            try {
                connPool.add(conn);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }


}
