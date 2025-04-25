package com.xzit.pay;

import org.springframework.context.annotation.Profile;

@Profile("dev")
public class PaymentImpl2 implements Payment {

    @Override
    public void pay() {
        System.out.println("橙心优选");
    }
}
