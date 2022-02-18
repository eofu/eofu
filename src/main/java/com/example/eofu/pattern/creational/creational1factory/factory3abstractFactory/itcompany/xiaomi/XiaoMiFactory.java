package com.example.eofu.pattern.creational.creational1factory.factory3abstractFactory.itcompany.xiaomi;


import com.example.eofu.pattern.creational.creational1factory.factory3abstractFactory.itcompany.AbstractFactory;
import com.example.eofu.pattern.creational.creational1factory.factory3abstractFactory.itcompany.Computer;
import com.example.eofu.pattern.creational.creational1factory.factory3abstractFactory.itcompany.Phone;

public class XiaoMiFactory  implements AbstractFactory {
    @Override
    public Computer makeComputer() {
        return new MiComputer();
    }
    
    @Override
    public Phone makePhone() {
        return new MiPhone();
    }
}
