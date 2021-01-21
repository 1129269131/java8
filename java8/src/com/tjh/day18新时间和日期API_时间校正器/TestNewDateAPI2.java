package com.tjh.day18新时间和日期API_时间校正器;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class TestNewDateAPI2 {

    /* TemporalAdjuster: 时间校正器 */
    @Test
    public void test1(){
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt2 = ldt.withDayOfMonth(10);// 指定日时间
        System.out.println(ldt2);

        System.out.println("------华丽的分割线------");

        LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));// 下一周日
        System.out.println(ldt3);
    }

    /* TemporalAdjuster自定义，获取下一个工作日 */
    @Test
    public void test2(){
        LocalDateTime ldt = LocalDateTime.now();

        LocalDateTime ldt2 = ldt.with((t) -> {
            LocalDateTime ldt3 = (LocalDateTime) t;
            DayOfWeek dow = ldt3.getDayOfWeek();

            if(dow.equals(DayOfWeek.FRIDAY)){
                return ldt3.plusDays(3);
            }else if(dow.equals(DayOfWeek.SATURDAY)){
                return ldt3.plusDays(3);
            }else{
                return ldt3.plusDays(1);
            }
        });

        System.out.println(ldt2);
    }

}
