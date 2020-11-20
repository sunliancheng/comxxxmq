package com.xxx.designPattern.factory;

public class BJCheesePizza implements Pizza {

    BJCheesePizza() {
        doSth();
    }

    @Override
    public void doSth() {
        System.out.println("make BJCheesePizza");
    }
}
