package com.ruyin.code.core.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by gbagony on 2016/12/23.
 */
public class AdvanceOperate {

    public static <I,O>List<O> map(Stream<I> stream, Function<I,O> mapper){
        return stream.reduce(new ArrayList<O>(),(acc,x)->{
            List<O> newAcc = new ArrayList<O>(acc);
            newAcc.add(mapper.apply(x));
            return newAcc;
        },(List<O> left,List<O> right) ->{
            List<O> newLeft = new ArrayList<O>(left);
            newLeft.addAll(right);
            return newLeft;
        });
    }
}
