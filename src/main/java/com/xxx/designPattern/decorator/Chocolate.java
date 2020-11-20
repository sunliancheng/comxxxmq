package com.xxx.designPattern.decorator;

public class Chocolate extends Decorator {

    public Chocolate(Drink i) {
        super(i);
        setDes("巧克力");
        setPrice(3.0f);
    }
}
