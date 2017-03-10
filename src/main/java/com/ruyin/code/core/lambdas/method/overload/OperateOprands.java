package com.ruyin.code.core.lambdas.method.overload;


import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * Created by ruyin on 2017/3/10.
 */
public class OperateOprands {

    public static void overloadedMethod(BinaryOperator<Integer> lambda){
        System.out.println(lambda.apply(2,2));
        System.out.println("BinaryOperator");
    }

    public static void overloadedMethod(IntegerBiFuntion lambda){
        System.out.println("IntegerBiFunction");
    }

    public static void overloadedMethod(Predicate<Integer> lambda){
        System.out.println("Predicate");
    }

    public static void overloadedMethod(IntPredict lambda){
        System.out.println("IntPredict");
    }

    public static void main(String[] args) {
        //显式指定了，不指定javac会选择相对具体的类型
        BinaryOperator<Integer> operator = (x,y) -> x*y;
        //System.out.println(operator.apply(1,2));
        overloadedMethod(operator);
        //无法确定采用哪种重载方法
        //overloadedMethod((x) -> true);
    }
}
