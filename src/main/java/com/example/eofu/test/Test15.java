package com.example.eofu.test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Test15 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Callable<Integer>> callableList = Arrays.asList(() -> {
            System.out.println(1);
            return null;
        }, () -> {
            System.out.println(2);
            return null;
        });
        executorService.invokeAny(callableList);

    }
}
