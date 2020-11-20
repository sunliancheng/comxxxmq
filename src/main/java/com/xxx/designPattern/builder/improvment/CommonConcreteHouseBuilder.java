package com.xxx.designPattern.builder.improvment;

public class CommonConcreteHouseBuilder extends HouseBuilder {

    @Override
    public void buildBase() {
        System.out.println("普通房子打地基5m");
    }

    @Override
    public void buildWalls() {
        System.out.println("普通房子造墙壁高10m");
    }

    @Override
    public void buildRoof() {
        System.out.println("普通房子建造屋顶");
    }
}
