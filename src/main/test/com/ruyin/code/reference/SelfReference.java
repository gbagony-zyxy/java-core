package com.ruyin.code.reference;

import com.ruyin.code.core.lambdas.compatible.method.*;
import com.ruyin.code.interview.title.FirstNotRepeatingChar;
import com.ruyin.code.interview.title.StringOperate;
import com.ruyin.code.interview.title.TwoDimensinalArrayOperate;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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


    @Test
    public void testOptional(){
        Optional<String> optional = Optional.of("a");
        System.out.println(optional.get());

        Optional emptyOptional = optional.empty();
        Optional alsoEmpty = Optional.ofNullable("a");

        System.out.println(emptyOptional);
        System.out.println(alsoEmpty);

        System.out.println(emptyOptional.isPresent());
        System.out.println(emptyOptional.orElse("b"));
        System.out.println(emptyOptional.orElseGet(() -> "c"));
    }


    @Test()
    public void testElementOrder(){
        List<Integer> numbers = Arrays.asList(1,2,3,4);

        List<Integer> sameOrder = numbers.stream().collect(Collectors.toList());

        System.out.println(numbers);
        System.out.println(sameOrder);

        Map map = new HashMap();
        map.put(null,"gg");
        //map.put(null,null);
        Object list = map.keySet().stream().map(key -> key).collect(Collectors.toList());
        System.out.println(list);
        System.out.println(map.get(null));

        User user = new User("ruyin","ruyin@gmail.com","13396542145",24);

        ClassLoader userLoader = user.getClass().getClassLoader();

        System.out.println(userLoader);


        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
    }

    @Test(expected = java.lang.ArithmeticException.class)
    public void testExpected(){
        System.out.println(1 / 0);
    }

    @Test
    public void testStr(){
        String str1 = "abc";
        String str2 = "abc";

        String str3 = new String("abc");

        System.out.println(str1 == str2);

        str1 = "def";
        //String类型定义的值行为与基本类型字面值行为类似，
        System.out.println(str1 + "," + str2);
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
    }

    @Test
    public void testMap(){
        //保证线程安全
        Map map = Collections.synchronizedMap(new HashMap<>());
    }
}
