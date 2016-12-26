package com.ruyin.code.core.lambdas;

import java.util.Optional;

/**
 * Created by gbagony on 2016/12/26.
 */
public class TestOptional {

    public static void main(String[] args) {
        Optional<String> str = Optional.of("abc");
        System.out.println(str.get());

        Optional emptyOption = Optional.empty();
        Optional alsoEmpty = Optional.ofNullable(null);
        //使用Optional对象的方式之一是在调用get()方法前,先调用isPresent()检查Optional对象是否有值
        System.out.println(emptyOption.isPresent());
        System.out.println(str.isPresent());
    }

}
