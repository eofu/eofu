package com.example.eofu.pattern.structural.structural1proxy.dynamicproxy.cglib.example01;

public class CglibTest {
    public static void main(String[] args) {
        Customer customer = new Customer();
        PaoTui paoTui = new PaoTui();
        Customer instance = (Customer) paoTui.getInstance(Customer.class);
        instance.buy();
    }
}
