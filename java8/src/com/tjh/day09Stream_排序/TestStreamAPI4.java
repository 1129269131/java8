package com.tjh.day09Stream_排序;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestStreamAPI4 {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 37, 5555.99),
            new Employee("赵六", 16, 3333.33),
            new Employee("田七", 8, 7777.77),
            new Employee("田七", 8, 7777.77),
            new Employee("田七", 8, 7777.77)
    );

    /* sorted()--自然排序(Comparable) */
    @Test
    public void test1(){
        List<String> list = Arrays.asList("ccc", "aaa", "bbb", "ddd", "eee");

        list.stream()
                .sorted()
                .forEach(System.out::println);
    }

    /* sorted(Comparator com)--定制排序(Comparator) */
    @Test
    public void test2(){
        employees.stream()
                .sorted((e1, e2) -> {
                    if(e1.getAge().equals(e2.getAge())){
                        return e1.getName().compareTo(e2.getName());
                    }else{
                        return e1.getAge().compareTo(e2.getAge());
                    }
                }).forEach(System.out::println);
    }

    @Test
    public void test3(){
        employees.stream()
                .sorted((e1, e2) -> {
                    if(e1.getAge().equals(e2.getAge())){
                        return e1.getName().compareTo(e2.getName());
                    }else{
                        return -e1.getAge().compareTo(e2.getAge());
                    }
                }).forEach(System.out::println);
    }

}
