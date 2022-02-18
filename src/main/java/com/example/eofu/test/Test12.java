package com.example.eofu.test;

import com.alibaba.dubbo.common.utils.StringUtils;


import java.util.Arrays;
import java.util.List;

public class Test12 {
    public static void main(String[] args) throws Exception {
        List<String> userIdList = Arrays.asList("123", "43", "23", "54", "5");
        String userIds = "'" + StringUtils.join(userIdList, "','") + "";
        System.out.println(userIds);
        System.out.println(userIdList);
    }
}
