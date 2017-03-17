package com.ruyin.code.core.lambdas.multiple.extend;

/**
 * Created by ruyin on 2017/3/17.
 */
public interface Jukebox {

    public default String rock(){
        return "... from side to side!";
    }
}
