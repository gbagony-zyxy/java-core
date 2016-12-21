package com.ruyin.code.core.advice.principle.method;

import java.util.Random;

/**
 *  勿使常量变变量
 */
public class ConstVar {
    public static void main(String[] args) {
        System.out.println("变化的常量:"+Const.RAND_CONST);
    }
}

interface Const{
    public static final int RAND_CONST = new Random().nextInt();
}
