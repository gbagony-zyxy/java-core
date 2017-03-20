package com.ruyin.code.core.lambdas.advance.collect;

import com.ruyin.code.core.lambdas.music.Album;
import com.ruyin.code.core.lambdas.music.Artist;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ruyin on 2017/3/20.
 */
public class CollectionsOperate {

    public Optional<Artist> biggestGroup(Stream<Artist> artists){
        //处理流，将每个artist的members统计一下
        Function<Artist,Long> getCount = artist -> artist.getMembers().count();
        //Collectors的maxBy与minBy
        return artists.collect(Collectors.maxBy(Comparator.comparing(getCount)));
    }

    public double averageNumberOfTracks(List<Album> albums){
        //Collectors收集器提供的averagingInt()方法进行数值运算
        return albums.stream().collect(Collectors.averagingInt(album -> album.getTrackList().size()));
    }


}
