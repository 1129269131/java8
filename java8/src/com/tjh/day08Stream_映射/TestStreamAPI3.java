package com.tjh.day08Stream_映射;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestStreamAPI3 {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 37, 5555.99),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 3333.33),
            new Employee("田七", 8, 7777.77)
    );

    /* map：接收 Lambda ，将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素 */
    @Test
    public void test1(){
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");

        list.stream()
                .map((str) -> str.toUpperCase())
                .forEach(System.out::println);

        System.out.println("------华丽的分割线------");

        employees.stream()
                 .map(Employee::getName)
                 .forEach(System.out::println);
    }

    /* flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流 */
    @Test
    public void test2(){
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");

        Stream<Stream<Character>> stream = list.stream()
                .map(TestStreamAPI3::filterCharacter);// {{a, a, a}, {b, b, b}}

        stream.forEach((sm) -> {
            sm.forEach(System.out::println);
        });

        System.out.println("------华丽的分割线------");

        Stream<Character> sm = list.stream()
                .flatMap(TestStreamAPI3::filterCharacter);// {a, a, a, b, b, b}

        sm.forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();

        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }

        return list.stream();
    }

    // 类似与list.add()方法与list.addAll()的区别
    @Test
    public void test3(){
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");

        List list2 = new ArrayList();
        list2.add(11);
        list2.add(22);

        /*list2.add(list);
        System.out.println(list2);*/

        System.out.println("------华丽的分割线------");

        list2.addAll(list);
        System.out.println(list2);
    }

}
