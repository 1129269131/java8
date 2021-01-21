package com.tjh.day10Stream_查找与匹配;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 *
 * 终止操作1
 *
 * */
public class TestStreamAPI5 {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, Employee.Status.FREE),
            new Employee("李四", 37, 5555.99, Employee.Status.BUSY),
            new Employee("王五", 26, 5555.99, Employee.Status.VOCATION),
            new Employee("赵六", 16, 3333.33, Employee.Status.FREE),
            new Employee("田七", 8, 7777.77, Employee.Status.BUSY)
    );

    /* allMatch: 检查是否匹配所有元素 */
    @Test
    public void test1(){
        boolean b1 = employees.stream()
                .allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));

        System.out.println(b1);
    }

    /* anyMatch: 检查是否至少匹配一个元素 */
    @Test
    public void test2(){
        boolean b2 = employees.stream()
                .anyMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));

        System.out.println(b2);
    }

    /* noneMatch: 检查所有元素是否都不匹配 */
    @Test
    public void test3(){
        boolean b3 = employees.stream()
                .noneMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));

        System.out.println(b3);
    }

    /* findFirst: 返回第一个元素 */
    @Test
    public void test4(){
        Optional<Employee> op = employees.stream()
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();

        System.out.println(op.get());
    }

    /* findAny: 返回当前流中的任意元素 */
    @Test
    public void test5(){
        Optional<Employee> op = employees.stream()// 串行，单线程查找，找到的结果固定
                .filter((e) -> e.getStatus().equals(Employee.Status.FREE))
                .findAny();

        System.out.println(op.get());
    }

    @Test
    public void test6(){
        Optional<Employee> op = employees.parallelStream()// 并向: 多线程一起找，找到的结果随机
                .filter((e) -> e.getStatus().equals(Employee.Status.FREE))
                .findAny();

        System.out.println(op.get());
    }

    /* count: 返回流中元素的总个数 */
    @Test
    public void test7(){
        Long count = employees.stream()
                .count();

        System.out.println(count);
    }

    /* max: 返回流中最大值 */
    @Test
    public void test8(){
        Optional<Employee> op = employees.stream()
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));

        System.out.println(op.get());
    }

    /* min: 返回流中最小值 */
    @Test
    public void test9(){
        Optional<Employee> op = employees.stream()
                .min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));

        System.out.println(op.get());
    }

    // 需求: 返回公司中工资的最小值
    @Test
    public void test10(){
        Optional<Double> op = employees.stream()
                .map(Employee::getSalary)
                .min(Double::compare);

        System.out.println(op.get());
    }

}
