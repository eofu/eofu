package com.example.eofu.juc.a_000;

public class T03_Sleep_Yeild_Join {
    static void testYeild() {
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("A:" + i);
                if (i % 10 == 0) {
                    Thread.yield();
                }
            }
        }).start();
        
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("B:" + i);
                if (i % 10 == 0) {
                    Thread.yield();
                }
            }
        }).start();
    }
    
    public static void main(String[] args) {
        // 保证另一个线程的执行，在t2中调用t1.join()，使t1加入t2中运行，t2运行完再运行t1
        // testJoin();
        // 使cpu循环调用程序等待一定时间，时间结束进入就绪状态
        // testSleep();
        // 暂时让出cpu
        testYeild();
    }
    
    static void testSleep() {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("A:" + i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    
    static void testJoin() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("A:" + i);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            for (int i = 0; i < 10; i++) {
                System.out.println("B:" + i);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
