package com.example.eofu.test;

import java.util.ArrayList;
import java.util.List;

public class Test16 {
    public static void main(String[] args) {
        List<Long[]> pageList = new ArrayList<>();
        Long count = 1000L;
        long pageCount = 3000;
        long page = count / pageCount;
        long lastPage = count % pageCount;
        if (page == 0 && lastPage > 0) {
            Long[] lastArray = {0L, lastPage};
            pageList.add(lastArray);
        }
        for (long i = 0; i < page; i++) {
            Long[] longArray = {i * pageCount, pageCount};
            pageList.add(longArray);

            if (lastPage > 0) {
                if (i == page - 1) {
                    pageList.add(longArray);
                    Long[] lastArray = {i * pageCount + pageCount, lastPage};
                    pageList.add(lastArray);
                }
            }
        }
        for (Long[] longs : pageList) {
            System.out.println(longs[0] + "   " + longs[1]);
        }
    }
}
