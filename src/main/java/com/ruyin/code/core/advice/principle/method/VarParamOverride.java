package com.ruyin.code.core.advice.principle.method;

/**
 *  覆写变长方法也循规蹈矩(覆写的方法参数与父类相同，不仅仅是类型、数量，还包括显示形式)
 */
public class VarParamOverride {
    public static void main(String[] args) {
        Base base = new Sub();
        base.fun(100,50);

        Sub sub = new Sub();
        //sub.fun(100, 50);
    }
}

class Base{
    void fun(int price,int... discount){
        System.out.println("Base......fun");
    }
}

class Sub extends Base{
    @Override
    void fun(int price, int[] discount) {
        System.out.println("Sub......fun");
    }
}
