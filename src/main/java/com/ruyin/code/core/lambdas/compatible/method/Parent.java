package com.ruyin.code.core.lambdas.compatible.method;

/**
 * Created by ruyin on 2017/3/16.
 */
public interface Parent {

    void message(String text);

    default void welcome(){
        message("Parent:Hello Java!");
    }

    String getLastMessage();
}
