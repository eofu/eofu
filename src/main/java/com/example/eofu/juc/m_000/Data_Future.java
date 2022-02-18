package com.example.eofu.juc.m_000;

public class Data_Future<T> {
    private T realData;
    private boolean isOK = false;

    public synchronized T getRealData() {
        while (!isOK) {
            try {
                // ����δ׼������ȴ�
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return realData;
    }

    public synchronized void setRealData(T data) {
        isOK = true;
        realData = data;
        notifyAll();
    }
}
