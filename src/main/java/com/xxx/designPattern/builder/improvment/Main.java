package com.xxx.designPattern.builder.improvment;

public class Main {

    public static void main(String[] args) {
        House house = new Director(new CommonConcreteHouseBuilder()).constructHouse();
        house.getBase();

        StringBuilder sb = new StringBuilder();
    }
}
