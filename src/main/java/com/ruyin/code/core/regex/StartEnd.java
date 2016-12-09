package com.ruyin.code.core.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  start( ) returns the start index of the previous match,
 *  and end( ) returns the index of the last character matched<br/>
 *
 *   find( ) will locate the regular expression anywhere in the input,but
        lookingAt( ) and matches( ) only succeed if the regular expression starts matching at the
        very beginning of the input.
 */
public class StartEnd {
    public static  String input = "As long as there is injustice, whenever a\n" +
            "Targathian baby cries out, whenever a distress\n" +
            "signal sounds among the stars ... We'll be there.\n" +
            "This fine ship, and this fine crew ...\n" +
            "Never give up!Never surrender!";

    private static  class  Display{
        private boolean regexPrinted = false;
        private String regex;
        Display(String regex){ this.regex = regex;}
        void display(String message){
            if(!regexPrinted){
                System.out.println(regex);
                regexPrinted = true;
            }
            System.out.println(message);
        }
    }

    static void examine(String s ,String regex){
        Display display = new Display(regex);
        Matcher matcher = Pattern.compile(regex).matcher(s);
        while(matcher.find())
            display.display("find() '"+matcher.group()+"' at position "+matcher.start()+" - "+matcher.end());
        if(matcher.lookingAt())
            display.display("lookingAt() '"+matcher.group()+"' start at position "+matcher.start()+" - "+matcher.end());
        if(matcher.matches())
            display.display("matches() '"+matcher.group()+"' start at position "+matcher.start()+" - " + matcher.end());
    }

    public static void main(String[] args) {
        for (String in: input.split("\n")) {
            System.out.println("input : " + in );
            for (String regex:new String[]{"\\w*ere","\\w*ever","T\\w+","Never.*?!"}) {
                examine(in,regex);
            }
        }
    }
}
