package com.ruyin.code.core.advice.principle.method;

/**
 *  10、不要在本类中覆盖静态导入的变量和方法(编译器如果能够在本类中查找到的变量、常量、方法，就不会到其他包或父类、接口中查找，以确保本类中的属性、方法优先)
 */
public class UnOverrideStaticImport {
    public final static String PI = "祖冲之";

    public static int abs(int abs){
        return 0;
    }

    public static void main(String[] args) {

        System.out.println("PI="+PI);
        System.out.println("abs(-100)="+abs(-100));
    }
}
