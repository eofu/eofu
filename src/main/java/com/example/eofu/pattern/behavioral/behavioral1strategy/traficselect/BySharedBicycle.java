package com.example.eofu.pattern.behavioral.behavioral1strategy.traficselect;

public class BySharedBicycle implements CalculateStrategy {
    @Override
    public int calculateTrafficFee(int distance) {
        return 2;
    }
}
