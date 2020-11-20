package com.xxx.designPattern.decorator;

public class Decorator extends Drink {
    private Drink drink;

    public Decorator(Drink i) {
        this.drink = i;
    }
    @Override
    public float cost() {
        return super.getPrice() + drink.getPrice();
    }

    @Override
    public String getDes() {
        return super.des + " " + super.getPrice() + " && "
                + drink.getDes();
    }
}
