package com.example.eofu.juc.a_001;

/**
 * synchronized关键字
 * 对某个对象枷锁
 */
public class T01_Synchronized_This {
    private static final Object o = new Object();
    private static int count = 10;
    
    public static void main(String[] args) {
        T01_Synchronized_This t01_synchronizedObject = new T01_Synchronized_This();
        for (int i = 0; i < 10; i++) {
            
            new Thread(() -> {
                System.out.println("t1");
                t01_synchronizedObject.countSub();
            }).run();
            new Thread(() -> {
                System.out.println("t2");
                t01_synchronizedObject.countSub();
            }).run();
        }
        
    }
    
    public void countSub() {
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread()
                                     .getName() + "count =" + count);
        }
    }
}
