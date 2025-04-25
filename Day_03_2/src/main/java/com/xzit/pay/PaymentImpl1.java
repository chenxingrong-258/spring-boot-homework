package com.xzit.pay;

import org.springframework.context.annotation.Profile;

@Profile("test")
public class PaymentImpl1 implements Payment {
    @Override

    public void pay() {
        System.out.println("多多买菜");

    }
}
