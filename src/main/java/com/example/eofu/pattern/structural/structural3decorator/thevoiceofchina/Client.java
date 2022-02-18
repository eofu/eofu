package com.example.eofu.pattern.structural.structural3decorator.thevoiceofchina;


import com.example.eofu.pattern.structural.structural3decorator.thevoiceofchina.afterdecorator.CompetitorDecorator;
import com.example.eofu.pattern.structural.structural3decorator.thevoiceofchina.afterdecorator.CompetitorDecoratorA;
import com.example.eofu.pattern.structural.structural3decorator.thevoiceofchina.afterdecorator.CompetitorDecoratorB;
import com.example.eofu.pattern.structural.structural3decorator.thevoiceofchina.afterdecorator.CompetitorDecoratorC;

public class Client {
    public static void main(String[] args) {
        Competitor competitor = new Competitor();
        
        CompetitorDecorator decorator = new CompetitorDecorator(competitor);
        decorator.sing();
        System.out.println();
        decorator = new CompetitorDecoratorA(decorator);
        decorator.sing();
        System.out.println();
        decorator = new CompetitorDecoratorB(decorator);
        decorator.sing();
        System.out.println();
        decorator = new CompetitorDecoratorC(decorator);
        decorator.sing();
        System.out.println();
    }
}
