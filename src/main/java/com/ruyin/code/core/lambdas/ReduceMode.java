package com.ruyin.code.core.lambdas;

import com.ruyin.code.core.lambdas.music.Track;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 *
 */
public class ReduceMode {

    static List<Track> tracks = Arrays.asList(new Track("Bakai",524),
            new Track("Violets for your furs",378),
            new Track("Times Was",451));

    public static void main(String[] args) {
        //testReduce();
        unfoldReduceOperator();
    }

    public static void testReduce(){
        int count = Stream.of(1,2,3)
                .reduce(0,(acc,element)->acc+element);
        System.out.println(count);
    }

    public static void unfoldReduceOperator(){
        BinaryOperator<Integer> accumulator = (acc,element)->acc+element;
        int count = accumulator.apply(accumulator.apply(accumulator.apply(0,1), 2), 3);
        System.out.println(count);
    }

    //通用模式
    public static void generalMode(){
        Track shortestTrack = tracks.get(0);
        for(Track track : tracks)
            if(track.getLength() < shortestTrack.getLength())
                shortestTrack = track;
    }
}
