package com.ruyin.code.core.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gbagony on 2016/12/7.
 */
public class TestRegularExpression {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.printf("Usage:\njava TestRegularExpression "+ "characterSequence regularExpression+");
            System.exit(-1);
        }
        System.out.printf("Input:\"" + args[0]+"\"");
        for (String arg: args) {
            System.out.println("Regular expression:\""+ arg +"\"");
            Pattern pattern = Pattern.compile(arg);
            Matcher matcher = pattern.matcher(args[0]);
            while(matcher.find()){
                System.out.println("Match \""+matcher.group()+"\" at positions"+matcher.start()+"-"+(matcher.end()-1));
            }
        }
    }
}
