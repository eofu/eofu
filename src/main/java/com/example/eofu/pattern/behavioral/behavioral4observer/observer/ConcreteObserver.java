package com.example.eofu.pattern.behavioral.behavioral4observer.observer;

/**
 * 具体观察者
 * @author yangs
 */
public class ConcreteObserver implements Observer{
    @Override
    public void update() {
        System.out.println("收到消息，进行处理");
    }
}
