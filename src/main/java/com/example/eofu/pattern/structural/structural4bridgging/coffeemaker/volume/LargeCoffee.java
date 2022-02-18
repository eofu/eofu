package com.example.eofu.pattern.structural.structural4bridgging.coffeemaker.volume;


import com.example.eofu.pattern.structural.structural4bridgging.coffeemaker.ICoffeeAdditives;
import com.example.eofu.pattern.structural.structural4bridgging.coffeemaker.RefinedCoffee;

public class LargeCoffee extends RefinedCoffee {
    public LargeCoffee(ICoffeeAdditives additives) {
        super(additives);
    }
    
    @Override
    public void orderCoffee(int count) {
        additives.addSomething();
        System.out.printf("大杯咖啡%d杯%n", count);
    }
}
