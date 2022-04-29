package com.example.eofu.test;

import java.util.ArrayList;
import java.util.List;

public class Test9 {
    public static void main(String[] args) {
        List<Long[]> pageList = new ArrayList<>();
        Long count = 5888L;
        Long page = count / 1000;
        Long lastPage = count % 1000;
        for (long i = 0; i < page + 1; i++) {
            Long[] longArray = {i * 1000, i * 1000 + 1000};
            pageList.add(longArray);
            if (i == page) {
                pageList.add(longArray);
                Long[] lastArray = {i * 1000 + 1000, i * 1000 + 1000 + lastPage};
                pageList.add(lastArray);
            }
        }
        pageList.forEach(entity -> {
            System.out.println(entity[0] + "  " + entity[1]);
            System.out.println();
        });
    }
}
