package com.ittest.proxy;

public class Producer implements IProcucer {
    @Override
    public void saleProduct(float money) {
        System.out.println("销售并拿到钱"+ money);
    }

    @Override
    public void afterService(float money) {
        System.out.println("售后服务并拿到钱"+ money);
    }
}
