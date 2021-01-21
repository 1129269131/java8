package com.tjh.day03Lambda练习;

import com.tjh.day01Lambda表达式.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestLambda {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 37, 5555.99),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 3333.33),
            new Employee("田七", 8, 7777.77)
    );

    /* 1.调用 Collections.sort() 方法，通过定制排序比较两个 Employee（先按年龄，年龄相同按姓名比），使用 Lambda 作为参数传递 */
    @Test
    public void test1(){
        Collections.sort(employees, (e1, e2) -> {
           if(e1.getAge() == e2.getAge()){
               return e1.getName().compareTo(e2.getName());
           } else {
               return -Integer.compare(e1.getAge(), e2.getAge());
           }
        });

        for (Employee emp : employees){
            System.out.println(emp);
        }
    }

    // 声明函数式接口的应用 需求：用于处理字符串
    @Test
    public void test2(){
        String trimStr = strHandler("\t\t\t 我大尚硅谷威武  ", (str) -> str.trim());
        System.out.println(trimStr);

        String upper = strHandler("abcdef", (str) -> str.toUpperCase());
        System.out.println(upper);

        String newStr = strHandler("我大尚硅谷威武", (str) -> str.substring(2, 5));
        System.out.println(newStr);
    }

    public String strHandler(String str, MyFunction mf){
        return mf.getValue(str);
    }

    // 需求：对于两个 Long 型数据进行处理
    @Test
    public void test3(){
        op(100L, 200L, (x, y) -> x + y);
        op(100L, 200L, (x, y) -> x * y);
    }

    public void op(Long l1, Long l2, MyFunction2<Long, Long> mf){
        System.out.println(mf.getValue(l1, l2));
    }
}
