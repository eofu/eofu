package com.example.eofu.test;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test17 {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> xhQueue = new ConcurrentLinkedQueue<>();
        ArrayList<String> objects = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            objects.add(String.valueOf(i));
        }
        xhQueue.addAll(objects);

        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        doSomeThing(xhQueue, threadPool);
    }

    private static void doSomeThing(ConcurrentLinkedQueue<String> xhQueue, ExecutorService threadPool) {
        CompletableFuture.runAsync(() -> {
            if (!xhQueue.isEmpty()) {
                String poll = xhQueue.poll();
                System.out.println(poll);
                doSomeThing(xhQueue, threadPool);
            }
        }, threadPool);
    }
}
