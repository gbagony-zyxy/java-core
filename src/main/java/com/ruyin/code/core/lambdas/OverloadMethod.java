package com.ruyin.code.core.lambdas;

import java.util.function.BinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 *
 */
public class OverloadMethod {

    public static void main(String[] args) {
        //overLoadMethod((x,y)-> x + y);
        //重载方法导致的编译无法识别方法,除非手动指定
        overLoadMethod1((IntPredicate)(x)->true);
    }


    private static void overLoadMethod(BinaryOperator<Integer> lambda){
        System.out.println(lambda.getClass().getName());
        System.out.println("BinaryOperator");
    }
    private static void overLoadMethod(IntegerBiFunction lambda){
        System.out.println(lambda.getClass().getName());
        System.out.println("IntegerBiFunction");
    }

    private static void overLoadMethod1(Predicate<Integer> predicate){
        System.out.println("Predicate");
    }

    private static void overLoadMethod1(IntPredicate intPredicate){
        System.out.println("IntPredicate");
    }
}
