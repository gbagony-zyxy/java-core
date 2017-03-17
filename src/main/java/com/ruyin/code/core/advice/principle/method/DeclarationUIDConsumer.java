package com.ruyin.code.core.advice.principle.method;

/**
 * Created by ruyin on 2016/12/21.
 */
public class DeclarationUIDConsumer {
    public static void main(String[] args) {
       /* Person person = (Person) SerializationUtils.readObject();
        System.out.println("name=" + person.getName());*/
        //System.out.println("age=" + person.getAge());

        PersonP p = (PersonP) SerializationUtils.readObject();
        System.out.println(p.name);
    }
}
