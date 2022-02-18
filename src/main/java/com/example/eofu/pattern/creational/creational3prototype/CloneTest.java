package com.example.eofu.pattern.creational.creational3prototype;

public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Police police = new Police();
        police.name = "police";
        police.age = 30;
        
        Police clonePolice = (Police) police.clone();
        System.out.println(clonePolice.name + clonePolice.age);
        System.out.println(clonePolice == police);
    }
}
