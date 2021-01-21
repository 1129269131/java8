package com.tjh.day01Lambda表达式;


import org.junit.Test;

import java.util.*;

public class Lambda1 {

    // 原来的匿名内部类
    @Test
    public void test1(){
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    // Lambda 表达式
    @Test
    public void test2(){
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<>(com);
    }


    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 37, 5555.99),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 3333.33),
            new Employee("田七", 8, 7777.77)
    );

    // 需求：获取当前公司中员工年龄大于35的员工信息
    @Test
    public void test3(){
        List<Employee> list = filterEmployees(employees);

        for(Employee employee : list){
            System.out.println(employee);
        }
    }

    public List<Employee> filterEmployees(List<Employee> list){
        List<Employee> emps = new ArrayList<>();

        for (Employee emp : list){
            if(emp.getAge() >= 35){
                emps.add(emp);
            }
        }

        return emps;
    }

    // 需求：获取当前公司中员工工资大于5000的员工信息并遍历出来
    /* 注：Stream API */
    @Test
    public void test4(){
        employees.stream()
                 .filter((e) -> e.getSalary() >= 5000)
                 .forEach(System.out::println);
    }

    // 需求：获取当前公司中员工工资大于5000的员工信息的前两个并遍历出来
    @Test
    public void test5(){
        employees.stream()
                .filter((e) -> e.getSalary() >= 5000)
                .limit(2)
                .forEach(System.out::println);
    }

    // 需求：获取当前公司中所有员工的名字信息
    @Test
    public void test6(){
        employees.stream()
                 .map(Employee::getName)
                 .forEach(System.out::println);
    }

}
