package com.ruyin.code.core.advice.principle.method;

/**
 *  8、不要让旧语法困扰你
 */
public class OldGrammar {
    public static void main(String[] args) {
        int fee = 200;
        //旧的goto语法:意为调用saveDefault()方法则跳到save()方法处
        saveDefault:save(fee);
    }
    static void saveDefault(){
        System.out.println("default");
    }
    static void save(int fee){
        System.out.println("save");
    }
}
