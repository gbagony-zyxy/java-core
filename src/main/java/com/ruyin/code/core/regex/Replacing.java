package com.ruyin.code.core.regex;

/**
 * Created by ruyin on 2016/12/6.
 */
public class Replacing {
    static  String s = Splitting.knights;
    public static void main(String[] args) {
        //替换第一个以字母f开头的，后面跟一个或者多个字母
        System.out.println(s.replaceFirst("f\\w+","located"));
        //替换三个单词中的任意一个
        System.out.println(s.replaceAll("shrubbery|tree|herring","banana"));
        //在the和you处分割
        System.out.println("This is a interesting book.".matches("^[A-Z]*$."));

        System.out.println("aaaaab".matches("a*b"));
    }
}
