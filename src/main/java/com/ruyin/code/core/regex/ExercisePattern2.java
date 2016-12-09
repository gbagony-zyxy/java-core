package com.ruyin.code.core.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  匹配更复杂的正则
 */
public class ExercisePattern2 {
    public static void main(String[] args) {
        String source = "Arline ate eight apples and one orange while Anita hadn't any";
        //(?i)表示字符集不区分大小写
        String regex = "(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        while(matcher.find()){
            System.out.println("Match \""+matcher.group()+"\" at position "+matcher.start()+" - "+(matcher.end()-1));
        }
    }
}
