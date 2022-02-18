package com.example.eofu.java8.future.completable.service;

import com.example.eofu.java8.future.completable.entity.MedalInfo;

public class MedalService {
    public MedalInfo getMedalInfo(long userId) throws InterruptedException {
        // 模拟调用耗时
        Thread.sleep(500);
        return new MedalInfo("666", "守护勋章");
    }
}
