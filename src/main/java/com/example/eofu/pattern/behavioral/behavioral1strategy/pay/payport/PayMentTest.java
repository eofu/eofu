package com.example.eofu.pattern.behavioral.behavioral1strategy.pay.payport;

import com.example.eofu.pattern.behavioral.behavioral1strategy.pay.Order;

public class PayMentTest {
    public static void main(String[] args) {
        Order order = new Order("84617689723", "123131345", 998.99);
        
        System.out.println(order.pay(PayTypeEnum.ALI_PAY));
        System.out.println(order.pay(PayTypeEnum.JD_PAY));
        System.out.println(order.pay(PayTypeEnum.WECHAT_PAY));
    }
}
