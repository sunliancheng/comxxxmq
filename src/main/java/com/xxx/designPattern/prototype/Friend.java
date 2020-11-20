package com.xxx.designPattern.prototype;

public class Friend implements Cloneable {

    public String name = "friend";

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
