package com.example.eofu.pattern.structural.structural3decorator.thevoiceofchina.afterdecorator;


import com.example.eofu.pattern.structural.structural3decorator.thevoiceofchina.Competitor;

public class CompetitorDecorator extends Competitor {
    private final Competitor competitor;
    
    public CompetitorDecorator(Competitor competitor) {
        this.competitor = competitor;
    }
    
    @Override
    public void sing() {
        competitor.sing();
    }
}
