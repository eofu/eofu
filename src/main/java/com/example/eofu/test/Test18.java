package com.example.eofu.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test18 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            int finalI = i;
            CompletableFuture.runAsync(()->{
                try {
                    Thread.sleep(1000L);
                    System.out.println("    "+finalI);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            },threadPool);

            if (i==99) {

                threadPool.shutdown();
            }
        }
    }
}
