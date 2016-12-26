package com.ruyin.code.core.lambdas;

import com.ruyin.code.core.lambdas.music.Track;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 */
public class MaxAndMin {
    public static void main(String[] args) {
        testMaxAndMin();
    }


    public static void testMaxAndMin(){
        List<Track> tracks = Arrays.asList(new Track("Bakai",524),
                                new Track("Violets for your furs",378),
                                new Track("Times Was",451));

        Track shortestTrack = tracks.stream().min(Comparator.comparing(track -> track.getLength()))
                            .get();

        Track longestTrack = tracks.stream().max(Comparator.comparing(track -> track.getLength()))
                            .get();

        System.out.println("Min length track:"+shortestTrack.getName());
        System.out.println("Max length track:"+longestTrack.getName());
    }
}
