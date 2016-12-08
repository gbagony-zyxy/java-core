package com.ruyin.code.core.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  Pattern flags:
 *  Pattern.CANON_EQ
 *  Pattern.CASE_INSENSITIVE(?i)  important
 *  Pattern.COMMENTS(?x)   important
 *  Pattern.DOTALL(?s)
 *  Pattern.MULTILINE(?m)  important
 *  Pattern.UNICODE_CASE(?u)
 *  Pattern.UNIX_LINES(?d)
 */
public class ReFlags {
    public static void main(String[] args) {
        //support flags conjunction to use
        Matcher matcher = Pattern.compile("^java",Pattern.CASE_INSENSITIVE|Pattern.MULTILINE).matcher("java has regex\n" +
                "Java has regex\nJava has pretty good regular expression\n" +
                "Regular expressions are in Java");
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
