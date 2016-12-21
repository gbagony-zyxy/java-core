package com.ruyin.code.core.advice.principle.method;

import java.text.NumberFormat;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Math.PI;
import static java.text.NumberFormat.getInstance;

/**
 *  9、少用静态导入
 */
public class StaticImport {

    //静态导入导致代码难读
    public static void main(String[] args) {
        double s = PI * parseDouble("3.14");
        NumberFormat nf = getInstance();
        nf.setMaximumFractionDigits(parseInt("12"));
        formatMessage(nf.format(s));
    }

    public static void formatMessage(String s){
        System.out.println("面积:"+s);
    }
}
