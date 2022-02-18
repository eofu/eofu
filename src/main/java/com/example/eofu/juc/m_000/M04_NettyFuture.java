package com.example.eofu.juc.m_000;

import com.example.eofu.utils.DateUtils;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;

import java.util.concurrent.CountDownLatch;

public class M04_NettyFuture {
    public static void main(String[] args) throws InterruptedException {
        EventExecutorGroup group = new DefaultEventExecutorGroup(4);
        System.out.println("��ʼ:" + DateUtils.getNow());

        Future<Integer> f = group.submit(() -> {
            System.out.println("��ʼ��ʱ����:" + DateUtils.getNow());
            Thread.sleep(10000);
            System.out.println("������ʱ����:" + DateUtils.getNow());
            return 100;
        });

        f.addListener(new FutureListener<Object>() {
            @Override
            public void operationComplete(Future<Object> objectFuture) throws Exception {
                System.out.println("������:" + objectFuture.get());
            }
        });

        System.out.println("����:" + DateUtils.getNow());
        // �����ػ��߳��˳�
        new CountDownLatch(1).await();
    }
}
