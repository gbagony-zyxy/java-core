package com.ruyin.code.core.regex;

import com.ruyin.code.core.io.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class JGrep {
    public static void main(String[] args) {

        Matcher matcher = Pattern.compile("\\b[Ssct]\\w+").matcher(TextFile.read("src/main/java/com/ruyin/code/core/regex/JGrep.java"));
        int index = 0;
        while(matcher.find()){
            System.out.println(index++ +":"+matcher.group()+": " +matcher.start());
        }
    }
}
