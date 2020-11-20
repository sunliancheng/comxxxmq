package com.xxx.designPattern.bridge;

//充当桥的功能，调用Brand的open方法，
public abstract class Phone {

    private Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }

    protected void open() {
        this.brand.open();
    }

    protected void close() {
        this.brand.close();
    }

    protected void call() {
        this.brand.call();
    }

}
