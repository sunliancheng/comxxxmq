package com.xxx.designPattern.builder.improvment;

public class Director {

    HouseBuilder houseBuilder = null;

    //构造器
    public Director(HouseBuilder hb) {
        this.houseBuilder = hb;
    }

    //建造房子流程交给指挥者
    public House constructHouse() {
        houseBuilder.buildBase();
        houseBuilder.buildWalls();
        houseBuilder.buildRoof();
        return houseBuilder.buildHouse();
    }
}
