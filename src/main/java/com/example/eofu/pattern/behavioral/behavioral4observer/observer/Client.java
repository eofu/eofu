package com.example.eofu.pattern.behavioral.behavioral4observer.observer;

/**
 *
 * @author yangs
 */
public class Client {
    public static void main(String[] args) {
        // 创建主题
        ConcreteSubject subject = new ConcreteSubject();
        // 定义观察者
        ConcreteObserver observer = new ConcreteObserver();
        // 观察
        subject.addObserver(observer);
        // 活动
        subject.doSomething();
    }
}
