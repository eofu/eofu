package com.example.eofu.juc.m_000;

import java.util.concurrent.Executors;

public class Server {
    public Data_Future<String> getData() {
        final Data_Future<String> data = new Data_Future<>();
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.setRealData("");
        });
        return data;
    
    }
}
