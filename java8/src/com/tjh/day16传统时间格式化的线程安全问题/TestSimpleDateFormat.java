package com.tjh.day16传统时间格式化的线程安全问题;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class TestSimpleDateFormat {

    // Date 方式: 线程不安全
    @Test
    public void test1() throws Exception {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

            Callable<Date> task = new Callable<Date>() {
                @Override
                public Date call() throws Exception {
                    return sdf.parse("20161218");
                }
            };

            ExecutorService pool = Executors.newFixedThreadPool(10);

            List<Future<Date>> results = new ArrayList<>();

            for(int i = 0; i < 10; i++){
                results.add(pool.submit(task));
            }

            for (Future<Date> future : results) {
                System.out.println(future.get());
            }

            pool.shutdown();
        }

        // LocalDate 方式: 线程安全
        @Test
        public void test2() throws Exception {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");

            Callable<LocalDate> task = new Callable<LocalDate>() {
                @Override
                public LocalDate call() throws Exception {
                    return LocalDate.parse("20161218", dtf);
                }
            };

            ExecutorService pool = Executors.newFixedThreadPool(10);

            List<Future<LocalDate>> results = new ArrayList<>();

            for(int i = 0; i < 10; i++){
                results.add(pool.submit(task));
            }

            for (Future<LocalDate> future : results) {
                System.out.println(future.get());
            }

            pool.shutdown();
        }

    }



