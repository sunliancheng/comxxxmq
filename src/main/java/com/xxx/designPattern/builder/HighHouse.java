package com.xxx.designPattern.builder;

public class HighHouse extends AbstractHouse {
    @Override
    public void buildBasic() {
        System.out.println("high basic");
    }

    @Override
    public void buildWalls() {
        System.out.println("high walls");
    }

    @Override
    public void roofed() {
        System.out.println("high roof");
    }

    @Override
    public void build() {
        super.build();
    }
}
