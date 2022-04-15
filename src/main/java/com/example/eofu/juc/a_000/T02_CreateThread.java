package com.example.eofu.juc.a_000;

import java.util.concurrent.*;

/**
 * 启动线程的方式：<p>
 * 1、直接new<tr>
 * 2、继承Thread<tr>
 * 3、实现Runnable<tr>
 * 4、实现Callable<tr>
 * 5、Executors.newCachedThread()<tr>
 *
 * <tr>最终都是new一个Thread</tr>
 */
public class T02_CreateThread {
    public static void main(String[] args) throws Exception {
        // 直接new Thread()
        new Thread(() -> System.out.println("直接new Thread")).start();

        // 继承Thread
        new MyThread().start();

        // Runnable接口
        new Thread(new MyRun()).start();

        // callable接口
        // 第一种:调用call方法
        MyCall myCall = new MyCall();
        System.out.println(myCall.call());
        // 第二种使用futureTask
        FutureTask<String> futureTask = new FutureTask<>(new MyCall());
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());

        ExecutorService service = Executors.newCachedThreadPool();

    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("继承thread");
        }
    }

    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("实现Run");
        }
    }

    static class MyCall implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "实现call";
        }
    }
}
