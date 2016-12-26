package com.ruyin.code.core.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class LambdaSimpleCase {

    //实现runnable接口
    public static void impRunnable(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before java8,too many codes for little to do.");
            }
        }).start();

        new Thread(()-> System.out.println("In java8,Lambda expression rocks!")).start();
    }

    //List迭代
    public static void impListRecursivly(){
        List<String> list = Arrays.asList("String","Integer","Double","Character","Float");
        for (String str : list)
            System.out.println(str);
        System.out.println("#########");
        list.forEach(n -> System.out.println(n));

    }

    //Lambda表达式与函数式接口Predicate
    //过滤集合数据的许多共性
    public static void impListFilter(){
        List<String> language = Arrays.asList("Java","C++","C","Scala");
        filter(language,(str)->str.startsWith("J"));
        filter(language,(str)->str.endsWith("a"));
        filter(language,(str)->true);
    }

    public static void filter(List<String> names, Predicate<String> condition){
        names.stream().filter((name)->(condition.test(name))).forEach(System.out::println);
    }


    public static void main(String[] args) {
        //impRunnable();
        //impListRecursivly();
        //impListFilter();

        BinaryOperator<Long> add = (x, y)-> x + y;
        BinaryOperator<Long> multi = (x,y)-> x * y;
        System.out.println(add);
    }
}
