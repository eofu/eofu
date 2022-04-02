package com.example.eofu.mybatisplus.entity;

import com.example.eofu.mybatisplus.annotation.QueryCondition;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    @QueryCondition
    private String id;
    @QueryCondition
    private String name;
    private String age;
}
