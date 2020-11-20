package com.xxx.designPattern.factory;

public class BJPizzaFactory implements pizzaFactory{

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("BJCheese")) {
            pizza = new BJCheesePizza();
        } else if (type.equals("BJPepper"))
            pizza = new BJPepperPizza();
        return pizza;
    }
}
