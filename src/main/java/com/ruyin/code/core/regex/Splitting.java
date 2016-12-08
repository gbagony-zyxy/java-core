package com.ruyin.code.core.regex;

import java.util.Arrays;

/**
 *  String类自带的split()方法，具有正则效果
 */
public class Splitting {
    public static String knights = "Then, when you have found the shrubbery, you must cut down the mightiest tree in the forest... with ... a herring!";

    public static  void split(String regex){
        System.out.println(Arrays.toString(knights.split(regex)));
    }

    //\W表示非单词字符，\w表示一个单词字符，n\\W+表示字符n后面一个或多个非单词字符
    public static void main(String[] args) {
        split(",");
        split("\\w+");
        split("n\\W+");
    }
}
