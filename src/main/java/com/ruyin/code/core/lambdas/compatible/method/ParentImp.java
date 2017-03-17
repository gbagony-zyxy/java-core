package com.ruyin.code.core.lambdas.compatible.method;

/**
 * Created by ruyin on 2017/3/16.
 */
public class ParentImp implements Parent{

    private String text;

    @Override
    public void message(String text) {
        this.text = text;
    }

    @Override
    public String getLastMessage() {
        return text;
    }
}
