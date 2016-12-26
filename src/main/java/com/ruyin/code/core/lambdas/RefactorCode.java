package com.ruyin.code.core.lambdas;

import com.ruyin.code.core.lambdas.music.Album;
import com.ruyin.code.core.lambdas.music.Artist;
import com.ruyin.code.core.lambdas.music.SimpleData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * Created by gbagony on 2016/12/23.
 */
public class RefactorCode {

    public static void main(String[] args) {
        List<Artist> artists = SimpleData.getThreeArtists();
        refactorCode(artists);

        lowerCaseLetters("There is no shorway of success.");

        List<String> list = new ArrayList<>();
        list.add("Is life always this hard or is it just when you are a kid?");
        list.add("Always like this.");
        list.add("Oh...");
        mostLowerCaseLetters(list);
    }

    private static void oldCode(List<Artist> artists){
        int totalMembers = 0;
        for(Artist artist:artists){
            Stream<Artist> members = artist.getMembers();
            totalMembers += members.count();
        }
    }

    public static void refactorCode(List<Artist> artists){
        System.out.println(artists.stream()
                .map(artist -> artist.getMembers().count())
                .reduce(0L, (acc, num) -> acc + num)
                .intValue());
    }

    public static void expressionIncr(Album album){
        AtomicInteger count = new AtomicInteger(0);

    }

    public static void lowerCaseLetters(String str){
        System.out.println(str.chars().filter(Character::isLowerCase).count());
    }

    public static void mostLowerCaseLetters(List<String> list){
        System.out.println(list.stream().
                max(Comparator.comparing(s -> s.chars().filter(Character::isLowerCase).count())));
    }
}
