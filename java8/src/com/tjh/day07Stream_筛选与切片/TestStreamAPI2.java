package com.tjh.day07Stream_筛选与切片;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * 一、Stream 的三个操作步骤：
 *
 * 1.创建Stream
 *
 * 2.中间操作
 *
 * 3.终止操作（终端操作）
 *
 */
public class TestStreamAPI2 {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 37, 5555.99),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 3333.33),
            new Employee("田七", 8, 7777.77),
            new Employee("田七", 8, 7777.77),
            new Employee("田七", 8, 7777.77)
    );

    /* filter：接收 Lambda ，从流中排除某些元素 */
    // 内部迭代：迭代操作由 Stream API 完成
    @Test
    public void test1(){
        // 中间操作
        Stream<Employee> stream = employees.stream()
                .filter((e) -> e.getAge() > 35);

        // 终止操作：一次性执行全部内容，即“惰性求值”
        stream.forEach(System.out::println);

        System.out.println("--------华丽的分割线--------");

        // 中间操作：不会执行任何操作
        Stream<Employee> stream1 = employees.stream()
                .filter((e) -> {
                    System.out.println("Stream API 的中间操作");
                    return e.getAge() > 35;
                });
    }

    // 外部迭代
    @Test
    public void test2(){
        Iterator<Employee> it = employees.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    /* limit(n)：截断流，使其元素不超过给定的数量 */
    @Test
    public void test3(){
        employees.stream()
                 .filter((e) -> e.getSalary() > 5000)
                .limit(2)
                .forEach(System.out::println);
    }

    // 当找到限定数量的满足条件的数据后，不再往下迭代
    @Test
    public void test4(){
        employees.stream()
                .filter((e) -> {
                    System.out.println("短路！");
                    return e.getSalary() > 5000;
                })
                .limit(2)
                .forEach(System.out::println);
    }

    /* skip(n)：跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit(n)互补 */
    @Test
    public void test5(){
        employees.stream()
                 .filter((e) -> e.getSalary() > 5000)
                 .skip(2)
                 .forEach(System.out::println);
    }

    /* distinct：筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素 */
    @Test
    public void test6(){
        employees.stream()
                .filter((e) -> e.getSalary() > 5000)
                .skip(2)
                .distinct() // 类中需带有hashCode()与equals()方法
                .forEach(System.out::println);
    }

}
