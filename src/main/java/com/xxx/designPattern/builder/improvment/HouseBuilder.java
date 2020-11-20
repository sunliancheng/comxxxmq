package com.xxx.designPattern.builder.improvment;

//抽象类 说明建造流程
public abstract class HouseBuilder {

    protected House house = new House();

    //将建造流程写好
    public abstract void buildBase();

    public abstract void buildWalls();

    public abstract void buildRoof();

    //建造好后返回房子
    public House buildHouse() {
        return house;
    }

}
