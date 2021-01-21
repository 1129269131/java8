package com.tjh.day05方法引用与构造器引用;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 *
 * 一、方法引用：若 Lambda 体中的内容有方法已经实现了，我们可以使用“方法引用”
 *          （可以理解为方法引用是 Lambda 表达式的另外一种表现形式）
 *
 * 主要有三种语法格式：
 *
 *  对象::实例方法名
 *
 *  类::静态方法名
 *
 *  类::实例方法名
 *
 * 注意：
 *    1、Lambda 体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致！
 *    2、若 Lambda 参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用 类::实例方法名（ClassName::method）
 *
 * 二、构造器引用：
 *
 *    格式：
 *
 *    ClassName::new
 *
 *    注意：需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致！
 *
 * 三、数组引用：
 *
 *    Type[]::new;
 *
 */
public class TestMethodRef {

    /* 对象::实例方法名 */
    @Test
    public void test1(){
        Consumer<String> con = (x) -> System.out.println(x);

        PrintStream ps = System.out;
        Consumer<String> con1 = (x) -> ps.println();

        PrintStream ps1 = System.out;
        Consumer<String> con2 = ps1::println;

        Consumer<String> con3 = System.out::println;
        con3.accept("abcdef");
    }

    @Test
    public void test2(){
        Employee emp = new Employee();
        Supplier<String> sup = () -> emp.getName();
        String str = sup.get();
        System.out.println(str);

        Supplier<String> sup2 = emp::getName;
        String str2 = sup2.get();
        System.out.println(str2);
    }

    /* 类::静态方法名 */
    @Test
    public void test3(){
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);

        Comparator<Integer> com1 = Integer::compare;
    }

    /* 类::实例方法名 */
    @Test
    public void test4(){
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);

        BiPredicate<String, String> bp2 = String::equals;
    }

    /* 构造器引用 */
    @Test
    public void test5(){
        Supplier<Employee> sup = () -> new Employee();

        // 构造器引用方式
        Supplier<Employee> sup2 = Employee::new;
        Employee emp = sup2.get();
        System.out.println(emp);
    }

    @Test
    public void test6(){
        Function<Integer, Employee> fun = (x) -> new Employee(x);

        Function<Integer, Employee> fun2 = Employee::new;
        Employee emp = fun2.apply(101);
        System.out.println(emp);

        BiFunction<Integer, Integer, Employee> bf = Employee::new;
    }

    /* 数组引用：*/
    @Test
    public void test7(){
        Function<Integer, String[]> fun = (x) -> new String[x];
        String[] strs = fun.apply(10);
        System.out.println(strs.length);

        Function<Integer, String[]> fun2 = String[]::new;
        String[] strs2 = fun2.apply(20);
        System.out.println(strs2.length);
    }

}
