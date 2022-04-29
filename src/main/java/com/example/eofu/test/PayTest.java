package com.example.eofu.test;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.LinkedList;
import java.util.Random;

/**
 * 假设有如下的付款场景:
 * 给定本次付款总金额,从已有的账户中选择可支付金额足够的账户进行付款;
 * 要求给出本次支付使用的账户和每个账号需要支付的金额
 * 要求是面向对象思想, 账户不限
 *
 * @author yangs
 */
public class PayTest {
    private static final LinkedList<Account> ACCOUNT_LIST = new LinkedList<>();
    private static final double TOTAL_PAY;

    static {
        // 创建10个随机余额账户
        for (int i = 0; i < 10; i++) {
            ACCOUNT_LIST.add(Account.builder().id(i).accountName("账户：" + i).money(new Random().nextDouble(80) + 20).build());
        }

        TOTAL_PAY = (new Random().nextDouble(80) + 20) * 9;
        System.out.println("需支付金额：" + TOTAL_PAY);
        System.out.println("不同账户拥有的余额：-------------");
        ACCOUNT_LIST.forEach(System.out::println);
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {
        PayTest payTest = new PayTest();
        payTest.pay(TOTAL_PAY);
    }

    private void pay(double TOTAL_PAY) {
        if (TOTAL_PAY > 0) {
            Account first = ACCOUNT_LIST.pollFirst();
//            ACCOUNT_LIST.
//                if (account.getMoney() >= TOTAL_PAY) {
//                    account.setMoney(TOTAL_PAY - account.getMoney());
//                    break;
//                }
//                TOTAL_PAY -= account.getMoney();

        }
    }
}

@Data
@SuperBuilder
class Account {
    private Integer id;
    private String accountName;
    private double money;
}
