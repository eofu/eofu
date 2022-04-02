package com.example.eofu.mybatisplus;

import com.example.eofu.mybatisplus.annotation.QueryCondition;
import com.example.eofu.mybatisplus.entity.Person;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Person person = new Person("id1", "name1", "age1");
        Test test = new Test();
    
        long l = System.currentTimeMillis();
        // test.getById(person);
        System.out.println(System.currentTimeMillis()-l);
    
        long l2 = System.currentTimeMillis();
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("name", person.getName());
        objectObjectHashMap.put("id1", person.getId());
        System.out.println(System.currentTimeMillis()-l2);
    }
    
    public <T> void getById(T t) throws IllegalAccessException {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
    
        Class<? extends Object> aClass = t.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(QueryCondition.class)) {
                declaredField.setAccessible(true);
                objectObjectHashMap.put(declaredField.getName(), declaredField.get(t));
            }
        }
    }
}
