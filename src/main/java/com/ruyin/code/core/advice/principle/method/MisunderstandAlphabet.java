package com.ruyin.code.core.advice.principle.method;

/**
 *  勿使用易混淆的字母,L应使用大写
 */
public class MisunderstandAlphabet {
    public static void main(String[] args) {
        long i = 1l;
        System.out.println("i 的两倍:"+(i+i));
    }
}
