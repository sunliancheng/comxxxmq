package com.xxx.designPattern.builder;

public class CommonHouse extends AbstractHouse {
    @Override
    public void buildBasic() {
        System.out.println("common basic");
    }

    @Override
    public void buildWalls() {
        System.out.println("common walls");
    }

    @Override
    public void roofed() {
        System.out.println("common roofed");
    }

}
