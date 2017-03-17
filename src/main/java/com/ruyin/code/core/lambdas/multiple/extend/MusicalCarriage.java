package com.ruyin.code.core.lambdas.multiple.extend;

/**
 * Created by ruyin on 2017/3/17.
 *
 * 接口使用多重继承可能会出现两个接口包含相同签名的情形，这时候就需要提供默认的实现
 */
public class MusicalCarriage implements Jukebox,Carriage{

    @Override
    public String rock() {
        //此处使用了增强的super语法,用来指明使用接口Carriage中定义的默认方法。
        //此前,使用super关键字指向父亲,现在使用类似InterfaceName.super语法指向继承自父接口的方法。
        return Carriage.super.rock();
    }
}
