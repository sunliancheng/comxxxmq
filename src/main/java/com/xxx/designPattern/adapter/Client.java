package com.xxx.designPattern.adapter;

public class Client {
    public static void main(String[] args) {

        new AbsAdapter() {
            @Override
            public void op1() {
                System.out.println("m1");
            }
        }.op1();



    }
}
