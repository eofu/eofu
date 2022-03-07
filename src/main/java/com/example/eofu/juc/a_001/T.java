package com.example.eofu.juc.a_001;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T implements Runnable {
    
    private /*volatile*/ int count = 100;
    private static List<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        for (int i = 0; i < 100; i++) {
            new Thread(t, "THREAD" + i).start();
        }
        Thread.sleep(50L);
        System.out.println(list.size());
    }
    
    @Override
    public void run() {
        count--;
        list.add(count);
        System.out.println(Thread.currentThread()
                                 .getName() + " count = " + count);
    }
}
