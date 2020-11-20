package com.xxx.designPattern.bridge;

public class Vivo implements Brand {
    @Override
    public void open() {
        System.out.println("vivo open");
    }

    @Override
    public void close() {
        System.out.println("vivo close");
    }

    @Override
    public void call() {
        System.out.println("vivo call");
    }
}
