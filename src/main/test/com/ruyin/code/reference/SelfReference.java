package com.ruyin.code.reference;

import com.ruyin.code.core.lambdas.compatible.method.*;
import com.ruyin.code.interview.title.FirstNotRepeatingChar;
import com.ruyin.code.interview.title.StringOperate;
import com.ruyin.code.interview.title.TwoDimensinalArrayOperate;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by gbagony on 2017/2/13.
 */
public class SelfReference {

    @Test
    public void test(){
        User user = new User("Joe","joe@gmail.com","17000000012",24);
        System.out.println(user);

        user.getAge().incrementAndGet();
        user = changeUserEmail(user);
        System.out.println(user);
    }

    private User changeUserEmail(User user) {
        user.setEmail("user@gmail.com");
        return user;
    }

    @Test
    public void testInteger(){
        System.out.println(new AtomicInteger().incrementAndGet());
    }

    @Test
    public void testArray(){
        /*int hashTable[] = new int[256];
        for(int i = 0;i < hashTable.length ; i++){
            System.out.println(hashTable[i]);
        }*/
        FirstNotRepeatingChar.firstNotRepeatingChar("");

        System.out.println(TwoDimensinalArrayOperate.findElementInArray(new int[]{1,2,3,4,5,6,7,8,9},3,3,6));

        System.out.println(StringOperate.replaceBlank1("we are happy!"));

        StringOperate.replaceBlank("we are happy!");
    }

    @Test
    public void testHex(){
        int a = 0xA0;  //160
        int b = 0x140; //320
        System.out.println(a & b);
    }

    //java 8 中默认方法的细节
    @Test
    public void testDefaultOverride(){
        Parent parent = new ParentImp();
        parent.welcome();
        System.out.println(parent.getLastMessage());

        Child child = new ChildImp();
        child.welcome();
        System.out.println(child.getLastMessage());

        Parent override = new OverridingParent();
        override.welcome();
        System.out.println(override.getLastMessage());

        //与接口中定义的默认方法相比，类中重写的方法更具体
        Child child1 = new OverridingChild();
        child1.welcome();
        System.out.println(child1.getLastMessage());
    }
}
