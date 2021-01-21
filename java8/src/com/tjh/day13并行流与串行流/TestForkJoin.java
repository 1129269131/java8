package com.tjh.day13并行流与串行流;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 *
 * Stream API 可以声明性地通过 parallel() 与
 * sequential() 在并行流与顺序流之间进行切换
 *
 * */
public class TestForkJoin {

    /* ForkJoin框架 */
    @Test
    public void test1(){
        Instant start = Instant.now();

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(0, 100000000L);
        Long sum = pool.invoke(task);
        System.out.println(sum);

        Instant end = Instant.now();

        System.out.println("耗费时间为：" + Duration.between(start, end).toMillis());
    }

    /* 普通 for 循环 */
    @Test
    public void test2(){
        Instant start = Instant.now();

        long sum = 0L;
        for (long i = 0; i <= 100000000L; i++) {
            sum += i;
        }

        System.out.println(sum);

        Instant end = Instant.now();

        System.out.println("耗费时间为：" + Duration.between(start, end).toMillis());
    }

    /* java8 并行流 */
    @Test
    public void test3(){
        Instant start = Instant.now();

        // 串行流
        /*LongStream.rangeClosed(0, 100000000L)
                .reduce(0 ,Long::sum);*/

        // 并行流
        LongStream.rangeClosed(0, 100000000L)
                .parallel()
                .reduce(0 ,Long::sum);

        Instant end = Instant.now();

        System.out.println("耗费时间为：" + Duration.between(start, end).toMillis());
    }

}
