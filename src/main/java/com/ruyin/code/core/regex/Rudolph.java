package com.ruyin.code.core.regex;

/**
 * Created by gbagony on 2016/12/7.
 */
public class Rudolph {
    public static void main(String[] args) {
        for (String pattern : new String[]{"Rudolph","[rR]udolph","[rR][aeiou][a-z]ol.*","R.*"}){
            System.out.println("Rudolph".matches(pattern));
        }
    }
}
