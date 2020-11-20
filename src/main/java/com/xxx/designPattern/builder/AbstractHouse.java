package com.xxx.designPattern.builder;

public abstract class AbstractHouse {

    public abstract void buildBasic();

    public abstract void buildWalls();

    public abstract void roofed();

    // 一定会按照某种顺序执行
    public void build() {
        buildBasic();
        buildWalls();
        roofed();
    }
}
