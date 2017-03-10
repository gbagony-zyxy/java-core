package com.ruyin.code.lambdas.logger;

import com.ruyin.code.core.lambdas.music.Album;
import com.ruyin.code.core.lambdas.music.Track;
import org.apache.log4j.Logger;

import java.util.IntSummaryStatistics;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by ruyin on 2017/3/9.
 */
public class LoggerImp extends Logger {

    protected LoggerImp(String name) {
        super(name);
    }

    public void trace(Supplier<String> message){
        if(isTraceEnabled()){
            trace(message.get());
        }
    }

    public void trace(Predicate<String> message){
        if(isTraceEnabled()){
            trace(message.test(""));
        }
    }

    public void trace(Function<String,String> message){
        if(isTraceEnabled()){
            trace(message.apply(""));
        }
    }

    public static void printTrackLengthStatistics(Album album){
        IntSummaryStatistics statistics = album.getTracks()
                .mapToInt(Track::getLength)
                .summaryStatistics();

        System.out.printf("Max:%d,Min:%d,Ave:%f,Sum:%d",
                statistics.getMax(),
                statistics.getMin(),
                statistics.getAverage(),
                statistics.getSum());
    }
}
