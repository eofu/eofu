package com.example.eofu.test;

import java.util.Random;

public class Test12 {
    private static final double[] DOUBLES = new double[100000000];
    private static double sum;
    
    static {
        Random random = new Random(100000);
        for (int i = 0; i < DOUBLES.length; i++) {
            DOUBLES[i] = random.nextDouble();
        }
    }
    
    public static void main(String[] args) throws Exception {
        long startSingle = System.currentTimeMillis();
        for (double aDouble : DOUBLES) {
            sum += aDouble;
        }
        System.out.println(System.currentTimeMillis() - startSingle + ":  " + sum);
        
        long startMulti = System.currentTimeMillis();
        new Thread(() -> {
            for (int i = 0; i < DOUBLES.length / 2; i++) {
                sum += DOUBLES[i];
            }
        }).start();
        new Thread(() -> {
            for (int i = DOUBLES.length / 2; i < DOUBLES.length; i++) {
                sum += DOUBLES[i];
            }
        }).start();
        System.out.println(System.currentTimeMillis() - startMulti + ":  " + sum);
    }
}
