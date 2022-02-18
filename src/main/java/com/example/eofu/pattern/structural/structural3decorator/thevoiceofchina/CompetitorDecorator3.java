package com.example.eofu.pattern.structural.structural3decorator.thevoiceofchina;

public class CompetitorDecorator3 extends Competitor {
    @Override
    public void sing() {
        super.sing();
        this.introduceBackground();
    }
    
    private void introduceBackground() {
        System.out.println("悲惨背景介绍，博取同情，赢感情牌....");
    }
}
