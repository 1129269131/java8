package com.tjh.day17新时间与日期API_本地时间与时间戳;

import org.junit.Test;

import java.time.*;

public class TestLocalDateTime {

    // LocalDate LocalTime LocalDateTime
    /* 获取系统当前时间 */
    @Test
    public void test1(){
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
    }

    /* 指定时间 */
    @Test
    public void test2(){
        LocalDateTime ldt = LocalDateTime.of(2019, 7, 7, 11, 6, 59);
        System.out.println(ldt);
    }

    /* 时间加减 */
    @Test
    public void test3(){
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        System.out.println("------华丽的分割线------");

        LocalDateTime ldt1 = ldt.plusYears(2);
        System.out.println(ldt1);

        System.out.println("------华丽的分割线------");

        LocalDateTime ldt2 = ldt.minusMonths(2);
        System.out.println(ldt2);
    }

    /* 获取指定时间 */
    @Test
    public void test4(){
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        System.out.println(ldt.getYear());
        System.out.println(ldt.getMonthValue());
        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getHour());
        System.out.println(ldt.getMinute());
        System.out.println(ldt.getSecond());
    }

    // Instant: 时间戳（以 Unix 元年：1970年1月1日 00:00:00 到某个时间之间的毫秒值）
    /* 获取当前时间戳 */
    @Test
    public void test5(){
        Instant ins = Instant.now();// 默认获取 UTC 时区
        System.out.println(ins);
    }

    /* 带时区偏移量时间 */
    @Test
    public void test6(){
        Instant ins = Instant.now();
        System.out.println(ins);

        OffsetDateTime odt = ins.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);
    }

    /* 转毫秒（时间戳） */
    @Test
    public void test7(){
        Instant ins = Instant.now();
        System.out.println(ins);

        System.out.println(ins.toEpochMilli());
    }

    /* 对元年时间操作 */
    @Test
    public void test8(){
        Instant ins = Instant.ofEpochSecond(1);// 加1秒
        System.out.println(ins);
    }

    /* Duration: 计算两个“时间”之间的间隔 */
    @Test
    public void test9(){
        Instant ins1 = Instant.now();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        Instant ins2 = Instant.now();

        Duration duration = Duration.between(ins1, ins2);
        System.out.println(duration.toMillis());

        System.out.println("------华丽的分割线------");

        LocalTime lt1 = LocalTime.now();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        LocalTime lt2 = LocalTime.now();

        System.out.println(Duration.between(lt1, lt2).toMillis());
    }

    /* Period: 计算两个“日期”之间的间隔 */
    @Test
    public void test10(){
        LocalDate ld1 = LocalDate.of(2016, 1, 1);
        LocalDate ld2 = LocalDate.now();

        Period period = Period.between(ld1, ld2);
        System.out.println(period);

        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }

}
