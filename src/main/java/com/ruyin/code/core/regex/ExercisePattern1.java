package com.ruyin.code.core.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  Pattern类与Matcher类的使用
 */
public class ExercisePattern1 {
    public static void main(String[] args) {
        String source = "Java now has regular expression.";
        String[] regEx = {"^Java","\\Breg.*","n.w\\s+h(a|i)s","s?","s*","s+","s{4}","s{1}.","s{0,3}"};
        System.out.println("Source string :"+source);
        for(String regex : regEx){
            System.out.println("Regular expression:"+regex);
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(source);
            while(matcher.find()){
                System.out.println("Match \""+matcher.group()+"\" at positions "+matcher.start()+"-"+(matcher.end()-1));
            }
        }
    }
}
