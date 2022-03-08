package com.example.eofu.juc.a_000;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可以用lockInterruptibly
 * @author yangshuai
 */
public class T05_Interrup {
    public static void main(String[] args) {
        Thread thread = new Thread();
        // 打断某个线程（设置标志位）
        thread.interrupt();
        // 查询某线程是否被打断过（查询标志位）
        thread.isInterrupted();
        // 查询当前线程是否被打断过，并重置打断标志
        Thread.interrupted();
    }
}
