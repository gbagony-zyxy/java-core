package com.ruyin.code.core.regex;

import java.util.Scanner;
import java.util.regex.MatchResult;

/**
 *  扫描之时使用正则匹配复杂信息
 */
public class ThreatAnalyzer {
    static String threatData = "120.90.23.12@09/12/2016\n" +
            "204.12.23.45@09/12/2016\n" +
            "20.34.34.56@08/12/2016\n" +
            "127.0.0.1@05/12/2015\n" +
            "204.20.18.50@10/11/2011\n" +
            "[Next log section with different data format]";
    public static void main(String[] args) {
        Scanner scan = new Scanner(threatData);
        String regex = "(?m)(\\d+[.]\\d+[.]\\d+[.]\\d+)@(\\d{2}/\\d{2}/\\d{4})";
        while(scan.hasNext(regex)){
            scan.next(regex);
            MatchResult result = scan.match();
            String ip = result.group(1);
            String date = result.group(2);
            System.out.format("Threat on %s from %s\n",date,ip);
        }
    }
}
