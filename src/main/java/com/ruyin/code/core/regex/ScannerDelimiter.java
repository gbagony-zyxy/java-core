package com.ruyin.code.core.regex;

import java.util.Scanner;

public class ScannerDelimiter {
    public static void main(String[] args) {
        Scanner scan = new Scanner("12,42,78,99,42");
        scan.useDelimiter("\\s*,\\s*");
        while(scan.hasNext())
            System.out.println(scan.next());
    }
}
