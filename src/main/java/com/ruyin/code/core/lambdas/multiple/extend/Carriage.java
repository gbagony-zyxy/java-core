package com.ruyin.code.core.lambdas.multiple.extend;

/**
 * Created by ruyin on 2017/3/17.
 */
public interface Carriage {

    public default String rock(){
        return "... all over the world!";
    }
}
