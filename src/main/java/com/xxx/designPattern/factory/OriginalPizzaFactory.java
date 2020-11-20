package com.xxx.designPattern.factory;

public class OriginalPizzaFactory implements pizzaFactory {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("Cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("Pepper"))
            pizza = new PepperPizza();
        return pizza;
    }
}
