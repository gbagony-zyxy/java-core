package com.ruyin.code.core.lambdas;

import com.ruyin.code.core.lambdas.music.Artist;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Context {

    public final static ThreadLocal<DateFormatter> formatter = ThreadLocal.withInitial(()->new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy")));

    private static final ThreadLocal<DateFormatter> dateFormatter = new ThreadLocal<>();

    public static void main(String[] args) {
        //typePredicate(6);
        //impArtist();
        //testCollectMethod();
        //testMapOperator();
        //testFilterOperator();
        testFlatmap();
    }

    public static void testCollectMethod(){
        List<String> collected = Stream.of("a","b","c").collect(Collectors.toList());
        System.out.println(Arrays.asList("a","b","c").equals(collected));
    }

    public static void testMapOperator(){
        List<String> collected = Stream.of("ab","cd","good")
                .map(str -> str.toUpperCase())
                .collect(Collectors.toList());
        collected.stream().forEach(str -> System.out.println(str));
    }

    public static void testFilterOperator(){
        List<String> beginningWithDigits = Stream.of("1ab","ab1","a1b")
                .filter(value -> isDigit(value.charAt(0)))
                .collect(Collectors.toList());

        beginningWithDigits.stream().forEach(s -> System.out.println(s));
    }

    private static boolean isDigit(char c) {
        return  (c+"").matches("\\d$");
    }

    public static void impArtist(){
        Artist artist1 = new Artist("Jay Zhou","China");
        Artist artist2 = new Artist("GaoXiaosong","China");
        Artist artist3 = new Artist("WangWei","China");
        List<Artist> allArtists = new ArrayList<>();
        allArtists.add(artist1);
        allArtists.add(artist2);
        allArtists.add(artist3);
        int count = 0;
        //外部迭代
        for (Artist artist : allArtists){
            if(artist.isFrom("China"))
                count++;
        }
        System.out.println("Chinese' singer has:"+count);

        //内部迭代
        long num = allArtists.stream().filter((artist) -> artist.isFrom("China")).count();
        allArtists.stream()
                .filter(artist -> {
                    System.out.println(artist.getName());
                    return artist.isFrom("China");
                }).count();
        System.out.println("Num is:"+num);
    }

    //flatmap
    public static void testFlatmap(){
        List<Integer> together = Stream.of(Arrays.asList(1,2), Arrays.asList(3,4))
                .flatMap(numbers->numbers.stream())
                .collect(Collectors.toList());
        together.stream().forEach(number-> System.out.println(number));
    }

    /**
     *  等号右边并没有声明类型，系统根据上下文推断出类型信息
     */
    public static void impContext(){
        final char[] array = {'c','b'};
        final byte[] bytes = {'c','b'};
        final int[] ints = {'c','b'};
        for (Character character : array)
            System.out.print(character + "  ");
        System.out.println();
        for (Byte b : bytes)
            System.out.print(b + "  ");
        System.out.println();
        for (Integer i : ints)
            System.out.print(i + "  ");
    }

    //lambda表达式引用的是值，而不是变量，lambda表达式中引用既成事实上的final变量
    public static void referVal(){
        JButton button = new JButton("Test");
        String name = "wxz";
        //name实质上是final类型的值，故修改那么将导致lambda表达式编译无法通过
        //name = "gg";
        button.addActionListener(event-> System.out.println("hi "+name));
    }

    public static void typePredicate(int x){
        Predicate<Integer> atList = y -> y > 5;
        boolean b = atList.test(x);
        System.out.println(b);
    }

    public static void calculate(){
        //Function<Integer,Integer> add = (x,y) -> x + y;
    }

    public static void lambdaType(){
        Runnable runnable = () -> System.out.println("Hello world!");
        new JButton().addActionListener((event) -> System.out.println("Button clicked."));
    }

    public static void testCheck(){
        IntPred c = x -> x > 5;
        c.test(10);
    }

    //boolean check(Predicate<Integer> predicate);

    //boolean check(IntPred predicate);
}

interface IntPred{
    boolean test(Integer value);
}
