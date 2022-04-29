package com.example.eofu.juc.a_000;

/**
 * <p>操作系统线程状态</p>
 *
 * <tr>就绪（进程调度策略选中）->执行（等待某一事件：启动外围设备、申请资源、出现故障）->阻塞（等待事件的发生：外围事件发生、等待的资源得到满足、故障排除）->就绪
 * <tr>执行（分配的时间片用完）->就绪
 *
 * <p>Java线程状态</p>
 * <tr>1、NEW：线程刚刚创建还没有启动。new Thread()
 * <tr>2、RUNNABLE：可以运行状态，由线程调度器可以安排执行。thread.start()
 * <tr>3、WAITING：等待被唤醒。
 * <tr>4、TIMED_WAITING:隔一段时间后自动唤醒。
 * <tr>5、BLOCKED：被阻塞，正在等待锁。
 *      <tr>等待阻塞：wait
 *      <tr>同步阻塞：synchronized
 *      <tr>其他阻塞：sleep，join
 *
 * <tr>6、TERMINATED：线程结束。
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
