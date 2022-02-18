package com.example.eofu.pattern.creational.creational1factory.factory3abstractFactory.furniture;


import com.example.eofu.pattern.creational.creational1factory.factory1simplefactory.Furniture;

public abstract class AbstractFactory {
    public abstract Furniture getChair();
    public abstract Furniture getDesk();
    public abstract Furniture getSofa();
}
