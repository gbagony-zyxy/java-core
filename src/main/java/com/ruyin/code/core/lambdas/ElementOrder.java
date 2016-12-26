package com.ruyin.code.core.lambdas;

import java.util.*;
import java.util.stream.Collectors;

/**
 *  元素顺序问题
 */
public class ElementOrder {

    public static void main(String[] args) {
        //有序集合中创建一个流时，流中的元素就按照出现顺序排列
        List<Integer> numbers = Arrays.asList(1,2,3,4);
        List<Integer> sameOrder = numbers.stream()
                .collect(Collectors.toList());
        System.out.println(Objects.equals(numbers, sameOrder));


        //如果集合本身是无序的，则由此生成的流也是无序的
        Set<Integer> number = new HashSet<>(Arrays.asList(1,2,3,4));
        List<Integer> order = number.stream()
                .collect(Collectors.toList());
        System.out.println(Objects.equals(number, order));


        //一些中间操作会产生顺序
    }
}
