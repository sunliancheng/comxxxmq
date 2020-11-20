package com.xxx.designPattern.factory;

public class Main {

    public static void main(String[] args) {
        System.out.println(order(new OriginalPizzaFactory(), "Cheese"));
    }

    public static Pizza order(pizzaFactory factory, String type) {
        return factory.createPizza(type);
    }

}
