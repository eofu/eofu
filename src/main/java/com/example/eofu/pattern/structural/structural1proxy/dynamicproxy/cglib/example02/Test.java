package com.example.eofu.pattern.structural.structural1proxy.dynamicproxy.cglib.example02;

public class Test {
    public static void main(String[] args) {
        Frank frank = (Frank) ProxyFactory.getCgLibDynProxy(new Frank());
        frank.submit("proof");
        frank.defend();
    }
}
