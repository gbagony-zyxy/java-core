package com.ruyin.code.core.lambdas.concurrency.parallelism;

import com.ruyin.code.core.lambdas.music.Album;
import com.ruyin.code.core.lambdas.music.Track;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by ruyin on 2017/3/23.
 */
public final class ParallelStreamOperation {

    //串行流计算专辑曲目长度
    public static int serialArraySum(List<Album> albums){
        return albums.stream()
                     .flatMap(Album::getTracks)
                     .mapToInt(Track::getLength)
                .sum();
    }

    //并行流计算
    public static int parallelArraySum(List<Album> albums){
        return albums.parallelStream()
                     .flatMap(Album::getTracks)
                     .mapToInt(Track::getLength)
                .sum();
    }

    //使用蒙特卡洛模拟法并行化模拟掷骰子事件
    public static Map<Integer,Double> parallelDicRolls(int times){
        double fraction = 1.0 / times;
        return IntStream.range(0,times)
                        .parallel()
                        .mapToObj(twoDiceThrows())
                .collect(Collectors.groupingBy(side -> side,
                        Collectors.summingDouble(n -> fraction)));
    }

    //两次随机数(伪随机)之和
    private static IntFunction<Integer> twoDiceThrows() {
        return i -> {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            int firstThrow = random.nextInt(1,7);
            int secondThrow = random.nextInt(1,7);
            return firstThrow + secondThrow;
        };
    }

    /**###################并行化数组操作###################*/
    public static double[] imperativeInitilize(int size){
        double[] values = new double[size];
        for (int i = 0;i < values.length;i++){
            values[i] = i;
        }
        return values;
    }

    public static double[] parallelInitialize(int size){
        double[] values = new double[size];
        Arrays.parallelSetAll(values, i -> i);
        return values;
    }
    /**####################################################*/

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Map<Integer,Double> maps = parallelDicRolls(10);
        long end = System.currentTimeMillis();
        System.out.println("Total time:"+(end - start));
    }
}
