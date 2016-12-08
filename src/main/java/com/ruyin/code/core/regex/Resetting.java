package com.ruyin.code.core.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class Resetting {
    public static void main(String[] args) {
        Matcher matcher = Pattern.compile("[frb][aiu][gx]").matcher("fix the rug with bags.");
        //Matcher matcher = Pattern.compile("[frbaiugx]").matcher("fix the rug with bags.");
        while(matcher.find())
            System.out.print(matcher.group()+" ");
        System.out.println();
        //带参数则将matcher应用于新的字符序列中
        //不带参数则将matcher对象重新设置到当前字符序列的起始位置
        matcher.reset("fix the rig with bags.");
        while(matcher.find())
            System.out.print(matcher.group()+" ");
    }
}
