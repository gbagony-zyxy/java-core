package com.ruyin.code.core.advice.principle.method;

/**
 *  三目运算符的类型必须一致
 */
public class TernaryOperator {
    public static void main(String[] args) {
        int i = 80;
        String s = String.valueOf(i < 100?90:100);
        String s1 = String.valueOf(i < 100?90:100.0);
        System.out.println(s.equals(s1));
    }
}
