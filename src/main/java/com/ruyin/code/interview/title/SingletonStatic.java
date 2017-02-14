package com.ruyin.code.interview.title;

/**
 *  面试题2：利用静态代码块实现单例
 *
 *  静态代码块在JVM启动的时候加载而且只加载一次,可以很好的实现单例
 */
public class SingletonStatic {
    private SingletonStatic(){}

    private static SingletonStatic instance = new SingletonStatic();

    public static SingletonStatic getInstance(){
        return instance;
    }
}
