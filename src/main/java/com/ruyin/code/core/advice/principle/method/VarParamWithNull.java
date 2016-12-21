package com.ruyin.code.core.advice.principle.method;

/**
 *  别让null值和空值威胁到变长方法,方法模糊不清，编译器不知道调用哪个方法
 */
public class VarParamWithNull {

    public void methodA(String str,Integer... is){}

    public void methodA(String str,String... strs){}

    public static void main(String[] args) {
        VarParamWithNull varParam = new VarParamWithNull();
        varParam.methodA("China",0);
        varParam.methodA("China","People");
        //varParam.methodA("China");
        //varParam.methodA("China",null);
    }
}
