package com.ruyin.code.core.lambdas.compatible.method;

/**
 * Created by ruyin on 2017/3/16.
 */
public interface Child extends Parent{

    @Override
    default void welcome() {
        message("Child:Hello Groovy!");
    }
}
