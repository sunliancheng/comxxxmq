package com.xxx.designPattern.factory;

public class CheesePizza implements Pizza {

    CheesePizza(){doSth();}

    @Override
    public void doSth() {
        System.out.println("make CheesePizza");
    }
}
