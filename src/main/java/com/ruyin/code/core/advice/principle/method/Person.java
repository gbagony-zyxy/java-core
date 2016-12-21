package com.ruyin.code.core.advice.principle.method;

import java.io.Serializable;

/**
 * 模拟生产者端
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 5799L;

    private String name;

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
