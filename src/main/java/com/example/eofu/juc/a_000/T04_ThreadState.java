package com.example.eofu.juc.a_000;

/**
 * Java线程状态
 * 1、NEW：线程刚刚创建还没有启动。new Thread()
 * 2、RUNNABLE：可以运行状态，由线程调度器可以安排执行。thread.start()
 * 3、WAITING：等待被唤醒。
 * 4、TIMED_WAITING:隔一段时间后自动唤醒。
 * 5、BLOCKED：被阻塞，正在等待锁。
 *      等待阻塞：wait
 *      同步阻塞：synchronized
 *      其他阻塞：sleep，join
 *
 * 6、TERMINATED：线程结束。
 */
public class T04_ThreadState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread();
        System.out.println(thread.getState());
        
        thread.start();
        System.out.println(thread.getState());
        
        // thread.join();
        // System.out.println(thread.getState());
        
        
        synchronized (thread) {
            thread.wait();
            System.out.println(thread.getState());
            thread.notify();
            System.out.println(thread.getState());
        }
        
        Thread.sleep(5000L);
        System.out.println(thread.getState());
    }
    
    
}
