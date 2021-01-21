package com.tjh.day11Stream_归约与收集;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestStreamAPI6 {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, Employee.Status.FREE),
            new Employee("李四", 37, 5555.99, Employee.Status.BUSY),
            new Employee("王五", 26, 5555.99, Employee.Status.VOCATION),
            new Employee("赵六", 16, 3333.33, Employee.Status.FREE),
            new Employee("田七", 8, 7777.77, Employee.Status.BUSY),
            new Employee("田七", 8, 7777.77, Employee.Status.BUSY)
    );

    // 归约
    /* reduce(T identity, BinaryOperator) / reduce(BinaryOperator): 可以将流中元素反复结合起来，得到一个值 */
    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        Integer sum = list.stream()
                .reduce(0, (x, y) -> x + y);

        System.out.println(sum);
    }

    @Test
    public void test2(){
        Optional<Double> op = employees.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);

        System.out.println(op.get());
    }

    // 收集
    /* collect: 将流转换为其他形式。接收一个 Collector 接口的实现，用于给Stream中元素做汇总的方法 */
    @Test
    public void test3(){
        List<String> list = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

        list.forEach(System.out::println);
    }

    @Test
    public void test4(){
        Set<String> set = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());

        set.forEach(System.out::println);
    }

    @Test
    public void test5(){
        HashSet<String> hs = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));

        hs.forEach(System.out::println);
    }

    // 流聚集（自己按照sql取的名字）
    @Test
    public void test6(){
        // 总数
        Long count = employees.stream()
                .collect(Collectors.counting());
        System.out.println(count);

        System.out.println("------总数分割线------");

        // 平均值
        Double avg = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avg);

        System.out.println("------平均值分割线------");

        // 总和
        Double sum = employees.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);

        System.out.println("------总和分割线------");

        // 最大值
        Optional<Employee> max = employees.stream()
                .collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(max.get());

        System.out.println("------最大值分割线------");

        // 最小值
        Optional<Double> min = employees.stream()
                .map(Employee::getSalary)
                .collect(Collectors.minBy(Double::compare));
        System.out.println(min.get());

        System.out.println("------最小值分割线------");
    }

    // 分组
    @Test
    public void test7(){
        // 单级分组
         Map<Employee.Status, List<Employee>> map = employees.stream()
                 .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);

        System.out.println("------单级分组分割线------");

        // 多级分组
        Map<Employee.Status, Map<String, List<Employee>>> map2 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
                    if(((Employee)e).getAge() <= 35){
                        return "青年";
                    }else if(((Employee)e).getAge() <= 50){
                        return "中年";
                    }else{
                        return "老年";
                    }
                })));
        System.out.println(map2);

        System.out.println("------多级分组分割线------");
    }

    // 分区
    @Test
    public void test8(){
        Map<Boolean, List<Employee>> map = employees.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() > 8000));

        System.out.println(map);
    }

    // 流统计
    @Test
    public void test9(){
        DoubleSummaryStatistics dss = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println(dss.getSum());
        System.out.println(dss.getAverage());
        System.out.println(dss.getMax());
    }

    // 连接字符串
    @Test
    public void test10(){
        String str = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining());

        System.out.println(str);

        System.out.println("------华丽的分割线------");

        String str2 = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(","));

        System.out.println(str2);

        System.out.println("------华丽的分割线------");

        String str3 = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(",", "===", "==="));

        System.out.println(str3);
    }

}
