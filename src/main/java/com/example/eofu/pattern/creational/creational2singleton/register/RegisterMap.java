package com.example.eofu.pattern.creational.creational2singleton.register;

import java.util.HashMap;

/**
 * 注册登记式：将对象存入缓存
 * IOC中的单例模式就是登记注册式
 *
 * @author yangs
 */
public class RegisterMap {
    private static final HashMap<String, Object> REGISTER = new HashMap<>();

    private RegisterMap() {

    }

    public static RegisterMap getInstance(String name) {
        if (name == null) {
            name = RegisterMap.class.getName();
        }

        if (REGISTER.get(name) == null) {
            REGISTER.put(name, new RegisterMap());
        }

        return (RegisterMap) REGISTER.get(name);
    }
}
