package com.example.eofu.java8.future.completable.futuredemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * <tr>thenApply提交的任务类型需遵从Function签名，也就是有入参和返回值，其中入参为前置任务的结果。
 * <tr>thenAccept提交的任务类型需遵从Consumer签名，也就是有入参但是没有返回值，其中入参为前置任务的结果。
 * <tr>thenRun提交的任务类型需遵从Runnable签名，即没有入参也没有返回值。
 *
 * <p>做完第一个任务后，再做第二个任务。某个任务执行完成后，执行回调方法；但是前后两个任务没有参数传递，第二个任务也没有返回值
 */
public class a03_ThenRunDemo {
    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
        CompletableFuture<String> firstFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("the first one task!");
            return "hello world";
        });
        
        CompletableFuture<Void> thenRun = firstFuture.thenRun(() -> {
            System.out.println("the secend task!");
        });
        
        System.out.println(thenRun.get());
    }
}
