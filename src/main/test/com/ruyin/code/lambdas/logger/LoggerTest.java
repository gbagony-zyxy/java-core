package com.ruyin.code.lambdas.logger;

import com.ruyin.code.core.lambdas.music.SimpleData;
import org.junit.Test;

import java.util.Date;

/**
 * Created by ruyin on 2017/3/9.
 */
public class LoggerTest {

    @Test
    public void test(){
        LoggerImp logger = new LoggerImp("Test");
        logger.trace(() -> "This is a good example.");
    }

    @Test
    public void testDate(){
        System.out.println(new Date(0));
    }

    @Test
    public void testIntStream(){
        LoggerImp.printTrackLengthStatistics(SimpleData.aLoveSupreme);
    }
}
