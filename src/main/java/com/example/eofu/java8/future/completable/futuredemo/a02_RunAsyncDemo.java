package com.example.eofu.java8.future.completable.futuredemo;

import java.util.concurrent.*;

/**
 * 与supplyAsync()不同的是，runAsync()传入的任务要求是Runnable类型的，所以没有返回值。
 */
public class a02_RunAsyncDemo {
    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
        // 自定义线程池
        ExecutorService executor = Executors.newCachedThreadPool();
        // runAsync的使用
        CompletableFuture<Void> runFuture = CompletableFuture.runAsync(() -> System.out.println("runnable"), executor);
        // supplyAsync的使用
        CompletableFuture<String> supplyFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("callable");
            return "callable_return";
        }, executor);
        System.out.println("runFuture.join()" + runFuture.join());
        System.out.println("supplyFuture.join()" + supplyFuture.join());
        executor.shutdown();
    }
}
