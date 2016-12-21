package com.ruyin.code.core.advice.principle.method;

import java.text.NumberFormat;

/**
 *  避免可变参数的重载,编译器会首先考虑原生的数据类型，而数组是一个对象，编译器会优先选择基本类型数据类型
 */
public class VarParmOverLoad {

    public void calPrice(int price,int discount){
        float knockDownPrice = price * discount / 100.0F;
        System.out.println("简单折算的价格:"+knockDownPrice);
    }

    public void calPrice(int price,int ... discounts){
        float knockdownPrice = price;
        for (int discount:discounts)
            knockdownPrice = knockdownPrice * discount / 100;

        System.out.println("折算后价格为:"+knockdownPrice);
    }

    private String formateCurrency(float price){
        return NumberFormat.getCurrencyInstance().format(price/100);
    }

    public static void main(String[] args) {
        VarParmOverLoad ol = new VarParmOverLoad();
        ol.calPrice(50000,50);
    }
}
