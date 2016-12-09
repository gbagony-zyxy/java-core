package com.ruyin.code.core.regex;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class Groups {
    static public final String POEM =
            "Twas brilling, and the slithy toves\n" +
            "Did gyre and gimble in the wabe.\n" +
            "All mimsy were the borogoves,\n" +
            "And the mome raths outgrabe.\n\n" +
            "Beware the Jabberwock,my son,\n" +
            "The jaws that bite,the claws that catch.\n" +
            "Beware the Jubjub bird,and shun\n" +
            "The frumious Bandersnatch.";

    public static void main(String[] args) {
        Set<String> words = new HashSet<>();
        //The regular expression's goal is to capture the last three words on each line
        Matcher matcher = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$")
                .matcher(POEM);
        while(matcher.find()){
            for(int j = 0; j< matcher.groupCount();j++)
                System.out.print("["+matcher.group(j)+"]");
            System.out.println();
        }
        System.out.println("######################");
        //The regular expression's goal is to capture the words which are not capital letter,Set responsibility for the unique.
        //()reprsent sub pattern
        Matcher match = Pattern.compile("\\b((?![A-Z])\\w+)\\b").matcher(Groups.POEM);
        while(match.find())
            words.add(match.group(0));
        System.out.println("Number of unique words = "+ words.size());
        System.out.println(words.toString());
    }
}
