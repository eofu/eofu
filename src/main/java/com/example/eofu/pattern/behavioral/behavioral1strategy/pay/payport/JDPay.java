package com.example.eofu.pattern.behavioral.behavioral1strategy.pay.payport;

import com.example.eofu.pattern.behavioral.behavioral1strategy.pay.PayState;

public class JDPay implements PayMent {
    @Override
    public PayState pay(String userId, Double amout) {
        System.out.println("选择京东");
        return new PayState("支付成功", amout, 200);
    }
}
