package com.example.eofu.pattern.behavioral.behavioral1strategy.pay.payport;

import com.example.eofu.pattern.behavioral.behavioral1strategy.pay.PayState;

public interface PayMent {
    PayState pay(String userId, Double amout);
}
