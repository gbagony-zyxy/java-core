package com.ruyin.code.core.lambdas;

import com.ruyin.code.core.lambdas.music.Album;
import com.ruyin.code.core.lambdas.music.SimpleData;
import com.ruyin.code.core.lambdas.music.Track;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 重构遗留代码
 */
public class RefactorOldCode {

    public static void main(String[] args) {
        List<Album> albums = SimpleData.getAlbums;
        findLongTrack(albums);
        refactorFindLongTrack(albums);
        reRefactorFindLongTrack(albums);
        reReReRefactorFindLongTrack(albums);
        reReReReRefactorFindLongTrack(albums);
    }

    //(遗留代码)获取所有专辑中长度大于一分钟的曲目
    public static void findLongTrack(List<Album> albums){
        Set<String> trackNames = new HashSet<>();
        for(Album album:albums)
            for(Track track:album.getTrackList())
                if(track.getLength() > 60){
                    String name = track.getName();
                    trackNames.add(name);
                }
        trackNames.stream().forEach(s -> System.out.println(s));
    }

    //(重构第一步)使用lambda与函数式编程重构，结构仍然复杂，迭代重构
    public static void refactorFindLongTrack(List<Album> albums){
        Set<String> trackNames = new HashSet<>();
        albums.stream()
                .forEach(album -> album.getTracks()
                    .forEach(track -> {
                        if(track.getLength() >60)
                            trackNames.add(track.getName());
                    }));
        trackNames.stream().forEach(s -> System.out.println(s));
    }

    //(重构第二步)结合filter与map来进行过滤和转换
    public static void reRefactorFindLongTrack(List<Album> albums){
        Set<String> trackNames = new HashSet<>();
        albums.stream()
                .forEach(album -> album.getTracks()
                    .filter(track -> track.getLength() > 60)
                    .map(track -> track.getName())
                    .forEach(name-> trackNames.add(name)));
        trackNames.stream().forEach(s -> System.out.println(s));
    }

    //(重构第三步)使用flatmap替换foreach操作
    public static void reReReRefactorFindLongTrack(List<Album> albums){
        Set<String> trackNames = new HashSet<>();

        albums.stream()
                .flatMap(album -> album.getTracks())  //将多个album的stream的合并为一个stream
                .filter(track -> track.getLength() > 60)
                .map(track -> track.getName())
                .forEach(name-> trackNames.add(name));
        trackNames.stream().forEach(s -> System.out.println(s));
    }

    //(重构第四步)使用及早求值方法代替foreach方法,完全不要手动定义变量
    public static void reReReReRefactorFindLongTrack(List<Album> albums){
        albums.stream()
                .flatMap(album -> album.getTracks())
                .filter(track -> track.getLength() > 60 && track.getLength() < 450)
                .map(track -> track.getName())
                .collect(Collectors.toSet())
                .forEach(s -> System.out.println(s));

    }

    public static void test(){
        ActionEvent localEvent = null;
        //鼓励我们使用lambda表达式获取值而不是变量
        new JButton().addActionListener(e -> {
            //localEvent = e;
        });
    }
}
