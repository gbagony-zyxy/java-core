package com.ruyin.code.core.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  Matcher.find()的使用:find()很像Iterator,在输入中查找匹配的内容
 */
public class Finding {
    public static void main(String[] args) {
        Matcher matcher = Pattern.compile("\\w+").matcher("Evening is full of the linnet's wings");
        while(matcher.find()){
            System.out.print(matcher.group()+" ");
        }
        System.out.println();
        int i = 0;
        while(matcher.find(i)){
            System.out.print(matcher.group()+"  ");
            i++;
        }
    }
}
