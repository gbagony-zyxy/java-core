package com.ruyin.code.core.lambdas;

import com.ruyin.code.core.lambdas.music.Album;
import com.ruyin.code.core.lambdas.music.Artist;
import com.ruyin.code.core.lambdas.music.SimpleData;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *  流操作
 */
public class StreamOperate {
    public static void main(String[] args) {
        /*Integer[] nums = new Integer[]{3,1,4,1,5,9,2,6};
        addUp(Arrays.stream(nums));
        List<Artist> artists = SimpleData.membersOfTheBeatles;
        showArtists(artists);
        getNameAndOrigins(artists);*/
        List<Album> albums = SimpleData.getAlbums;
        showAlbums(albums);
        getAlbums(albums);
    }

    public static void addUp(Stream<Integer> numbers){
        System.out.println(numbers.reduce(0, (acc, num) -> acc + num));
    }

    public static void showArtists(List<Artist> artists){
        artists.stream()
                .map(artist -> artist.getName()+"-->"+artist.getNationality())
                .collect(Collectors.toSet())
                .forEach(s -> System.out.println(s));
    }

    public static void getNameAndOrigins(List<Artist> artists){
        artists.stream()
                .flatMap(artist -> Stream.of(artist.getName(),artist.getNationality()))
                .collect(Collectors.toList())
                .forEach(s -> System.out.println(s));
    }


    public static void showAlbums(List<Album> albums){
        albums.stream()
                .filter(album -> album.getTracks().count() <= 3)
                .collect(Collectors.toList())
                .forEach(s-> System.out.println(s.getName()));
    }

    public static void getAlbums(List<Album> albums){
        albums.stream()
                .filter(album -> album.getTrackList().size() <= 3)
                .collect(Collectors.toList())
                .forEach(s-> System.out.println(s.getName()));
    }
}
