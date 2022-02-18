package com.example.eofu.pattern.creational.creational1factory.factory3abstractFactory.itcompany;


import com.example.eofu.pattern.creational.creational1factory.factory3abstractFactory.itcompany.apple.AppleFactory;
import com.example.eofu.pattern.creational.creational1factory.factory3abstractFactory.itcompany.xiaomi.XiaoMiFactory;

public class ItCompanyTest {
    public static void main(String[] args) {
        AppleFactory appleFactory = new AppleFactory();
        appleFactory.makeComputer().setOperationSystem();
    
        XiaoMiFactory xiaoMiFactory = new XiaoMiFactory();
        xiaoMiFactory.makePhone().setOperationSystem();
    }
}
