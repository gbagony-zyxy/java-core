package com.ruyin.code.reference;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ruyin on 2017/2/13.
 */
public class User {
    private String name;
    private String email;
    private String telephone;
    private AtomicInteger age;

    public User(){}

    public User(String name, String email, String telephone,int age) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.age = new AtomicInteger(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public AtomicInteger getAge() {
        return age;
    }

    public void setAge(AtomicInteger age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", age=" + age +
                '}';
    }
}
