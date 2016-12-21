package com.ruyin.code.core.advice.principle.method;

/**
 *  7、警惕自增的陷阱(i++是先赋值再加1，i++是一个表达式，有返回值，其返回值为i++自加前的值)
 */
public class WarnIncrement {

    public static void main(String[] args) {
        int count = 0;
        for(int i=0;i< 10 ;i++){
            //count = count++;
            count++;
        }
        System.out.println(count);
    }
}
