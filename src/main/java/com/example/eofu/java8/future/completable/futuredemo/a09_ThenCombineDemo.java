package com.example.eofu.java8.future.completable.futuredemo;

import java.util.concurrent.*;

/**
 * 将两个CompletableFuture组合起来，只有这两个都正常执行完了，才会执行某个任务。
 * 会将两个任务的执行结果作为方法入参，传递到指定方法中，且有返回值
 */
public class a09_ThenCombineDemo {
    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
        CompletableFuture<String> firstFuture = CompletableFuture.completedFuture("the first one Asyn task!");
        
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CompletableFuture<String> combineAsync = CompletableFuture.supplyAsync(() -> "the second task!", executor)
                                                                  .thenCombineAsync(firstFuture, (s, w) -> {
                                                                      System.out.println(w);
                                                                      System.out.println(s);
                                                                      return "two Async task combine";
                                                                  }, executor);
        CompletableFuture<Void> thenAsync = CompletableFuture.supplyAsync(() -> "the second task!", executor)
                                                             .thenAcceptBoth(firstFuture, (s, w) -> {
                                                                 if ("1".equals(w)) {
                                                                     System.out.println(111111);
                                                                 }
                                                                 if ("2".equals(s)) {
                                                                     System.out.println(222222);
                                                                 }
                                                             });
        String s = combineAsync.get();
        System.out.println(s);
        
        thenAsync.get();
        executor.shutdown();
    }
}
