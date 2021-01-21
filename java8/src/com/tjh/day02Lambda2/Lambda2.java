package com.tjh.day02Lambda2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * 一、Lambda表达式的基础语法：Java8中引入了一个新的操作符“->”该操作符称为箭头操作符或Lambda操作符
 *                          箭头操作符将 Lambda 表达式拆分成两部分
 * 左侧： Lambda 表达式的参数列表
 * 右侧： Lambda 表达式中所需执行的功能，即 Lambda 体
 *
 * 语法格式一： 无参数，无返回值
 *      () -> System.out.println("Hello Lambda!")
 *
 * 语法格式二： 有一个参数，并且无返回值
 *          (x) -> System.out.println(x)
 *
 * 语法格式三： 若只有一个参数，小括号可以省略不写
 *
 * 语法格式四： 有两个以上的参数，有返回值，并且 Lambda 体中有多条语句
 *      Comparator<Integer> com = (x, y) -> {
 *            System.out.println("函数式接口");
 *            return Integer.compare(x, y);
 *      };
 *
 * 语法格式五：若 Lambda 体中只有一条语句，return 和 大括号都可以省略不写
 *          Comparator<Integer> com = (x, y) -> Integer.compare(x, y)
 *
 * 语法格式六： Lambda 表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出数据类型，即“类型推断”
 *          反例：Comparator<Integer> com = (Integer x, Integer y) -> Integer.compare(x, y)
 *
 * 二、Lambda 表达式需要“函数式接口”的支持
 * 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。可以使用注解 @FunctionalInterface 修饰
 *              可以检查是否是函数式接口
 */
public class Lambda2 {

    /* 语法格式一 */
    @Test
    public void test1(){
        int num = 0; // jdk1.7 前，必须是final
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!" + num);
            }
        };

        r.run();

        System.out.println("----------------------------");

        Runnable r1 = () -> System.out.println("Hello Lambda!" + num);
        r1.run();
    }

    /* 语法格式二 */
    @Test
    public void test2(){
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("我大尚硅谷威武！");
    }

    /* 语法格式三 */
    @Test
    public void test3(){
        Consumer<String> con = x -> System.out.println(x);
        con.accept("我大尚硅谷威武！");
    }

    /* 语法格式四 */
    @Test
    public void test4(){
        Comparator<Integer> com = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
    }

    /* 语法格式五 */
    @Test
    public void test5(){
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
    }

    /* 语法格式六 反例 */
    @Test
    public void test6(){
        Comparator<Integer> com = (Integer x, Integer y) -> Integer.compare(x, y);
    }

    /* 语法格式六 正例: 上下文推断类型 */
    @Test
    public void test7(){
        // String[] strs = {"aaa", "bbb", "ccc"}; // 1
        /*String[] strs;
        strs = {"aaa", "bbb", "ccc"};*/ // 2
        List<String> list = new ArrayList<>(); // 3
    }

    /* 函数式接口 */
    @Test
    public void test8(){
        Integer num = operation(100, (x) -> x * x);
        System.out.println(num);

        System.out.println(operation(200, (y) -> y + 250));
    }

    public Integer operation(Integer num, MyFun mf){
        return mf.getValue(num);
    }

}
