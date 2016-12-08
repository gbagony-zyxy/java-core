package com.ruyin.code.basic.string;

/**
 *  正则表达式中?表示零个或一个，因为+在正则中有特殊意义，所以要加转义字符，
 *  \\d表示一位数字，后面带+表示多个数字
 */
public class IntegerMatch {
    public static void main(String[] args){
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("5678".matches("-?\\d+"));
        System.out.println("+911".matches("-?\\d+"));
        System.out.println("+911".matches("(-|\\+)?\\d+"));
    }
}
