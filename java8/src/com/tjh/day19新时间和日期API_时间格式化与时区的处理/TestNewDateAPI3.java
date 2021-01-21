package com.tjh.day19新时间和日期API_时间格式化与时区的处理;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class TestNewDateAPI3 {

    /* DateTimeFormatter: 格式化时间/日期 */
    @Test
    public void test1(){
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime ldt = LocalDateTime.now();

        String strDate = ldt.format(dtf);
        System.out.println(strDate);

        System.out.println("------华丽的分割线------");

        DateTimeFormatter dtf2 = DateTimeFormatter.ISO_DATE;
        LocalDateTime ldt2 = LocalDateTime.now();

        String strDate2 = ldt2.format(dtf2);
        System.out.println(strDate2);

        System.out.println("------华丽的分割线------");

        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        LocalDateTime ldt3 = LocalDateTime.now();

        String strDate3 = dtf3.format(ldt3);
        System.out.println(strDate3);
    }

    // 时区：ZonedDate、ZonedTime、ZonedDateTime
    /* 获取总的时区 */
    @Test
    public void test2(){
        Set<String> set = ZoneId.getAvailableZoneIds();
        set.forEach(System.out::println);
    }

    /* 指定时区获取时间 */
    @Test
    public void test3(){
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Europe/Tallinn"));
        System.out.println(ldt);

        System.out.println("------华丽的分割线------");

        LocalDateTime ldt2 = LocalDateTime.now(ZoneId.of("Europe/Tallinn"));
        ZonedDateTime zdt = ldt2.atZone(ZoneId.of("Europe/Tallinn"));
        System.out.println(zdt);
    }

}
