package com.xxx.designPattern.factory;

public class PepperPizza implements Pizza {

    PepperPizza(){doSth();}

    @Override
    public void doSth() {
        System.out.println("make PepperPizza");
    }
}
