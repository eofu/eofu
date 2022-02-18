package com.example.eofu.juc.m_000;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class M02_FutureTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<Integer>> futureList = new ArrayList<>();

        // ����1000��1��1�ڵĺ�
        for (int i = 0; i < 1000; i++) {
            // ����ִ��
            futureList.add(executorService.submit(new Calc()));
        }
        System.out.println("��ʱ: " + (System.currentTimeMillis() - start));

        for (int i = 0; i < 1000; i++) {
            try {
                Integer result = futureList.get(i).get();
                System.out.println("��" + i + "�����: " + result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("��ʱ: " + (System.currentTimeMillis() - start));
    }

    public static class Calc implements Callable<Integer> {
        public static int cal(int num) {
            int sum = 0;
            for (int i = 0; i < num; i++) {
                sum += i;
            }
            return sum;
        }

        @Override
        public Integer call() throws Exception {
            return cal(100000000);
        }
    }

}
