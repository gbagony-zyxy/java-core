package com.ruyin.code.core.regex;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *  在Scanner与正则表达式出来之前一直使用StringTokenizer来进行分词，现在该类已经很少用了
 */
public class ReplaceingStringTokenizer {
    public static void main(String[] args) {
        String input = "But I'm not dead yet!I feel Happy!";
        StringTokenizer tokenizer = new StringTokenizer(input);
        while(tokenizer.hasMoreElements()){
            System.out.print(tokenizer.nextToken()+" ");
        }
        System.out.println();
        System.out.println(Arrays.toString(input.split(" ")));
        Scanner scanner = new Scanner(input);
        while (scanner.hasNext()){
            System.out.print(scanner.next()+" ");
        }
    }
}
