package com.ruyin.code.core.lambdas;

import com.ruyin.code.core.lambdas.music.Album;
import com.ruyin.code.core.lambdas.music.SimpleData;

import java.util.IntSummaryStatistics;

/**
 *  统计曲目长度
 */
public class SummaryStatistic {
    public static void main(String[] args) {
        Album album = SimpleData.aLoveSupreme;
        printTrackLengthStatistics(album);
    }

    public static void printTrackLengthStatistics(Album album){
        IntSummaryStatistics trackLengthStats = album.getTracks()
                //引用的是对象则可以直接通过对象类名引用该对象的方法
                //.mapToInt(Track::getLength)
                .mapToInt(track->track.getLength())
                .summaryStatistics();

        System.out.printf("Max: %d,Min: %d,Ave: %f,sum: %d",
                trackLengthStats.getMax(),
                trackLengthStats.getMin(),
                trackLengthStats.getAverage(),
                trackLengthStats.getSum());
    }
}
