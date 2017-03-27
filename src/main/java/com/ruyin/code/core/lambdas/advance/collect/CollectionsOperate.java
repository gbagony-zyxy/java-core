package com.ruyin.code.core.lambdas.advance.collect;

import com.ruyin.code.core.lambdas.music.Album;
import com.ruyin.code.core.lambdas.music.Artist;
import com.ruyin.code.core.lambdas.music.SimpleData;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ruyin on 2017/3/20.
 */
public final class CollectionsOperate {

    public static Optional<Artist> biggestGroup(Stream<Artist> artists){
        //处理流，将每个artist的members统计一下
        Function<Artist,Long> getCount = artist -> artist.getMembers().count();
        //Collectors的maxBy与minBy
        return artists.collect(Collectors.maxBy(Comparator.comparing(getCount)));
    }

    public static double averageNumberOfTracks(List<Album> albums){
        //Collectors收集器提供的averagingInt()方法进行数值运算
        return albums.stream().collect(Collectors.averagingInt(album -> album.getTrackList().size()));
    }


    //数据分块,将艺术家分成独唱歌手和团队歌手。Collectors.partitioningBy()
    public static Map<Boolean,List<Artist>> bandAndSolo(Stream<Artist> artists){
        //return artists.collect(Collectors.partitioningBy(artist -> artist.isSolo()));
        //方法引用的形式
        return artists.collect(Collectors.partitioningBy(Artist::isSolo));
    }

    //数据分组,将专辑与主唱对应,此处的groupby与sql中的group by有异曲同工之妙
    public static Map<Artist,List<Album>> albumsByArtist(Stream<Album> albums){
        return albums.collect(Collectors.groupingBy(Album::getMainMusician));
    }

    //收集器提供处理字符串的简便方法,允许将多个结果输出为一个字符串,而且便于理解
    public static String getArtistNames(Stream<Artist> artists){
        return artists.map(Artist::getName).collect(Collectors.joining(",","[","]"));
    }

    //组合收集器,一个烂的实现
    public static Map<Artist,Integer> badCollectorJoin(Stream<Album> albums){
        Map<Artist,List<Album>> albumsByArtist = albums.collect(Collectors.groupingBy(Album::getMainMusician));

        Map<Artist,Integer> numberOfAlbums = new HashMap<>();
        for (Map.Entry<Artist,List<Album>> entry : albumsByArtist.entrySet()){
            numberOfAlbums.put(entry.getKey(),entry.getValue().size());
        }
        return numberOfAlbums;
    }

    //组合收集器,内置的实现,屏蔽中间的一些过程
    public static Map<Artist,Long> numberOfAlbums(Stream<Album> albums){
        return albums.collect(Collectors.groupingBy(Album::getMainMusician,Collectors.counting()));
    }

    //简单方式求每个艺术家的专辑名
    public static Map<Artist,List<String>> getNameAndArtist(Stream<Album> albums){
        Map<Artist,List<Album>> maps = albums.collect(Collectors.groupingBy(Album::getMainMusician));

        Map<Artist,List<String>> numberOfAlbums = new HashMap<>();
        for (Map.Entry<Artist,List<Album>> entry : maps.entrySet()){
            numberOfAlbums.put(entry.getKey(),entry.getValue().stream().map(Album::getName).collect(Collectors.toList()));
        }
        return numberOfAlbums;
    }

    //组合收集器,Collectors.mapping()允许在收集器的容器上执行类似map的操作
    public static Map<Artist,List<String>> nameOfAlbums(Stream<Album> albums){
        return albums.collect(Collectors.groupingBy(Album::getMainMusician,Collectors.mapping(Album::getName,Collectors.toList())));
    }

    /**####################################################################*/
    public static String refactor1(Stream<Artist> artists){
        StringBuilder sb = new StringBuilder("[");
        artists.map(Artist::getName)
                .forEach(name -> {
                    if(sb.length() > 1)
                        sb.append(",");
                    sb.append(name);
                });
        sb.append("]");
        return sb.toString();
    }

    public static String refactor2(Stream<Artist> artists){
        StringBuilder reduce = artists.map(Artist::getName)
                                      .reduce(new StringBuilder(),(sb,name) -> {
                                          if (sb.length() > 0)
                                              sb.append(",");
                                          sb.append(name);
                                          return sb;
                                      },(left,right) -> left.append(right));
        reduce.insert(0,"[");
        reduce.append("]");
        return reduce.toString();
    }

    public static String refactor3(Stream<Artist> artists){
        StringCombiner combiner = artists.map(Artist::getName)
                                         .reduce(new StringCombiner(",","[","]"),
                                                 StringCombiner::add,
                                                 StringCombiner::merge);
        return combiner.toString();
    }

    public static String refactor4(Stream<Artist> artists){
        return artists.map(Artist::getName)
                .collect(new StringCollector(",","[","]"));
    }
    /**####################################################################*/

    public static void main(String[] args) {
        /*String names =getArtistNames(SimpleData.getThreeArtists().stream());
        System.out.println(names);

        Map<Artist,List<Album>> albums = albumsByArtist(SimpleData.getAlbums.stream());
        System.out.println(albums);*/

        /*Map<Artist,Long> numberOfAlbums = numberOfAlbums(SimpleData.getAlbums.stream());
        System.out.println(numberOfAlbums);*/

        /*Map<Artist,List<String>> maps = getNameAndArtist(SimpleData.getAlbums.stream());
        System.out.println(maps);*/

        System.out.println(refactor3(SimpleData.getThreeArtists().stream()));
    }
}
