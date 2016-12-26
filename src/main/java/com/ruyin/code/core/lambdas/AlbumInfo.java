package com.ruyin.code.core.lambdas;

import com.ruyin.code.core.lambdas.music.Album;
import com.ruyin.code.core.lambdas.music.SimpleData;

import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 */
public class AlbumInfo {
    public static void main(String[] args) {
        Album album = SimpleData.aLoveSupreme;
        albumInfo(album);
    }

    public static void albumInfo(Album album){
        Set<String> origins = album.getMusicians() //获取所有的artist
                .filter(artist -> artist.getName().startsWith("The")) //过滤出是乐队的artist
                .map(artist -> artist.getNationality())     //找出artis的国籍
                .collect(Collectors.toSet());           //将过滤出的artist放入集合

        origins.stream().forEach(str-> System.out.println(str));       //打印出artist的国籍
    }
}
