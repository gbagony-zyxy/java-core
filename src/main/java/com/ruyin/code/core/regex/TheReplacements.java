package com.ruyin.code.core.regex;

import com.ruyin.code.core.io.TextFile;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*!
    Here's a block of text to use as input to the
    regular expression matcher.Note that we'll first
    extract the block of text by looking for the special
    delimeters,then process the extracted block!
!*/
public class TheReplacements {
    public static void main(String[] args) {
        String s = TextFile.read("src/main/java/com/ruyin/code/core/regex/TheReplacements.java");
        Matcher matcher = Pattern.compile("/\\*!(.*)!\\*/",Pattern.DOTALL).matcher(s);
        if(matcher.find()){
          s = matcher.group(1);
        }
        //replace two or more spces with no space
        s = s.replaceAll(" {2,}"," ");
        //replace multiline beginning one or more space with no space
        s = s.replaceAll("(?m)^ +","");
        System.out.println(s);

        //replace first matched condition
        s = s.replaceFirst("[aeiou]","(VOWEL1)");
        StringBuffer sb = new StringBuffer();
        Matcher matcher1 = Pattern.compile("[aeiou]").matcher(s);
        //process the information as you perform the replacements
        while(matcher1.find()){
            matcher1.appendReplacement(sb,matcher1.group().toUpperCase());
        }
        matcher1.appendTail(sb);
        System.out.println(sb);
    }
}
