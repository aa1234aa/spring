package com.ittest.cglib;

public class Producer{
    public void saleProduct(float money) {
        System.out.println("销售并拿到钱"+ money);
    }
    public void afterService(float money) {
        System.out.println("售后服务并拿到钱"+ money);
    }
}
