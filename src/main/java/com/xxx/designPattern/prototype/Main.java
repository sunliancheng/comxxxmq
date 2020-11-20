package com.xxx.designPattern.prototype;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException, IOException {

        Prototype p1 = new Prototype();

        Prototype p2 = (Prototype) p1.deepClone();
        //p2 = (Prototype) p1.clone();

        System.out.println(p1 == p2);
        System.out.println(p1.deepClone == p2.deepClone);
        System.out.println(p1.name == p2.name);

    }


}
