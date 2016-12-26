package com.ruyin.code.core.lambdas;

import com.ruyin.code.core.lambdas.music.Album;
import com.ruyin.code.core.lambdas.music.SimpleData;

import java.util.IntSummaryStatistics;

/**
 *  统计曲目长度<br/>
 *  IntStream/DoubleStream/LongStream类(因为这些类型在数值计算中用得最多)
 *  IntSummaryStatistics类
 *  mapToInt方法
 *  summaryStatistics方法(此方法能计算出各种各样的统计值)
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
