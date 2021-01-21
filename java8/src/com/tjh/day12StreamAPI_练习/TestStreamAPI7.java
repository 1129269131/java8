package com.tjh.day12StreamAPI_练习;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestStreamAPI7 {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, Employee.Status.FREE),
            new Employee("李四", 37, 5555.99, Employee.Status.BUSY),
            new Employee("王五", 26, 5555.99, Employee.Status.VOCATION),
            new Employee("赵六", 16, 3333.33, Employee.Status.FREE),
            new Employee("田七", 8, 7777.77, Employee.Status.BUSY)
    );

    /* 给定一个数字列表，返回一个由每个数的平方构成的列表 */
    @Test
    public void test1(){
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5};

        Arrays.stream(nums)
                .map((x) -> x * x)
                .forEach(System.out::println);
    }

    /* 使用 map 和 reduce 方法计算employees的数量 */
    @Test
    public void test2(){
        Optional<Integer> count = employees.stream()
                .map((e) -> 1)
                .reduce(Integer::sum);

        System.out.println(count.get());
    }

}
