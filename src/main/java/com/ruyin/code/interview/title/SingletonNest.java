package com.ruyin.code.interview.title;

/**
 *  面试题2：利用内部类实现单例
 *
 */
public class SingletonNest {

    private SingletonNest(){};

    public static SingletonNest getInstance(){
        return Nested.instance;
    }

    static class Nested{
        Nested(){}

        static SingletonNest instance = new SingletonNest();
    }
}
