package com.example.eofu.juc.a_000;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 启动线程的方式：
 * 1、Thread
 * 2、Run
 * 3、Executors.newCachedThread()
 *
 * <tr>最终都是new一个Thread</tr>
 */
public class T02_CreateThread {
    public static void main(String[] args) throws Exception {
        // 继承Thread
        new MyThread().start();
        
        // Runnable接口
        new Thread(new MyRun()).start();
        
        // 直接new Thread()
        new Thread(() -> System.out.println("lambda")).start();
        
        
        MyCall myCall = new MyCall();
        System.out.println(myCall.call());
        // callable接口
        FutureTask<String> futureTask = new FutureTask<>(new MyCall());
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }
    
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("thread");
        }
    }
    
    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Run");
        }
    }
    
    static class MyCall implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "call";
        }
    }
}
