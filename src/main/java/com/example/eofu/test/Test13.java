package com.example.eofu.test;

import java.io.IOException;

public class Test13 {
    class A {
        private int anInt = 10;
        
        A() {
            new Thread(() -> {
                System.out.println(this.anInt);
            }).start();
        }
    }
    
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10000; i++) {
            new Test13().new A();
        }
    }
}
