package com.example.eofu.juc.a_000;

/**
 * Java线程状态
 * 1、新建状态：new Thread()
 * 2、就绪状态（可执行状态）：thread.start()
 * 3、运行状态：获取CPU权限
 * 4、阻塞状态：放弃CPU使用权
 * 等待阻塞：wait
 * 同步阻塞：synchronized
 * 其他阻塞：sleep，join
 * 5、死亡状态：完成或异常退出run()
 */
public class T04_ThreadState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread();
        System.out.println(thread.getState());
        
        thread.start();
        System.out.println(thread.getState());
        
        thread.join();
        System.out.println(thread.getState());
        
        
        synchronized (thread) {
            // thread.wait();
            System.out.println(thread.getState());
        }
        
        Thread.sleep(10L);
        System.out.println(thread.getState());
    }
}
