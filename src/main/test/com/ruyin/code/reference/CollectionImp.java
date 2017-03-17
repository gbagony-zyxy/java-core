package com.ruyin.code.reference;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ruyin on 2017/3/16.
 *
 *
 */
public class CollectionImp {

    @Test
    public void testMap(){
        Map<GiftId,Integer> map = new HashMap<>();
    }

    @Test
    public void testAbstractList(){
        ArrayList<String> list = new ArrayList(){{add("gg");
            add("fly");
            add("zzz");
            add("hh");
        }};
        System.out.println(list.subList(0,4).get(2).getClass());
        System.out.println(list.subList(0,4).getClass());
    }

    @Test
    public void testToArray(){
        List<GiftId> list = new ArrayList() {{add(new GiftId("gg"));add(new GiftId("fly"));}};
        String[] array = new String[list.size()];
        //尽量使toArray(T[])方法带参数
        Object[] objects = list.toArray();
        System.out.println(array[0]);
        System.out.println(objects[0]);
    }
}
