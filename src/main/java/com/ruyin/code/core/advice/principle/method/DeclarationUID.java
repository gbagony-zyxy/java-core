package com.ruyin.code.core.advice.principle.method;

/**
 * 显式声明UID
 */
public class DeclarationUID {

    public static void main(String[] args) {
        /*Person person = new Person();
        person.setName("网络传输");
        //person.setAge(23);
        SerializationUtils.writeObject(person);*/
        SerializationUtils.writeObject(new PersonP());
    }

}
