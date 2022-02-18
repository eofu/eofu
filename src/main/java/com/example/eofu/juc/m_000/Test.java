package com.example.eofu.juc.m_000;

public class Test {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Server server = new Server();
        Data_Future<String> dataFuture = server.getData();

        try {
            // ��ִ����������
            Thread.sleep(1000);
            // ģ���ʱ...
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("������ݣ�" + dataFuture.getRealData());
        System.out.println("��ʱ: " + (System.currentTimeMillis() - start));
    }
}
