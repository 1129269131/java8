package com.tjh.day14Optional容器类;

import org.junit.Test;

import java.util.Optional;

public class TestOptional1 {

    /* Optional.of(T t): 创建一个 Optional 实例 */
    @Test
    public void test1(){
        Optional<Employee> op = Optional.of(new Employee());
        Employee emp = op.get();
        System.out.println(emp);
    }

    /* Optional.empty(): 创建一个空的 Optional 实例 */
    @Test
    public void test2(){
        Optional<Employee> op = Optional.empty();
        System.out.println(op.get());
    }

    /* Optional.ofNullable(T t): 若t不为null，创建 Optional 实例，否则创建空实例 */
    @Test
    public void test3(){
        Optional<Employee> op = Optional.ofNullable(new Employee());
        System.out.println(op.get());

        System.out.println("------华丽的分割线------");

        Optional<Employee> op1 = Optional.ofNullable(null);
        System.out.println(op1.get());
    }

    /* isPresent(): 判断是否包含值 */
    @Test
    public void test4(){
        Optional<Employee> op = Optional.ofNullable(null);

        if(op.isPresent()){
            System.out.println(op.get());
        }

        System.out.println("------华丽的分割线------");

        Optional<Employee> op2 = Optional.ofNullable(new Employee());

        if(op2.isPresent()){
            System.out.println(op2.get());
        }
    }

    /* orElse(T t): 如果调用对象包含值，返回该值，否则返回t */
    @Test
    public void test5(){
        Optional<Employee> op = Optional.ofNullable(null);
        Employee emp = op.orElse(new Employee("张三", 18, 888.88, Employee.Status.FREE));
        System.out.println(emp);

        System.out.println("------华丽的分割线------");

        Optional<Employee> op2 = Optional.ofNullable(new Employee());
        Employee emp2 = op2.orElse(new Employee("张三", 18, 888.88, Employee.Status.FREE));
        System.out.println(emp2);
    }

    /* orElseGet(Supplier s): 如果调用对象包含值，返回该值，否则返回 s 获取的值 */
    @Test
    public void test6(){
        Optional<Employee> op = Optional.ofNullable(null);

        Employee emp = op.orElseGet(() -> new Employee());
        System.out.println(emp);
    }

    /* map(Function f): 如果有值对其处理，并返回处理后的 Optional，否则返回 Optional.empty() */
    @Test
    public void test7(){
        Optional<Employee> op = Optional.ofNullable(new Employee("张三", 18, 888.88, Employee.Status.FREE));

        Optional<String> str = op.map((e) -> e.getName());
        System.out.println(str.get());
    }

    /* flatMap(Function mapper): 与 map 类似，要求返回值必须是 Optional */
    @Test
    public void test8(){
        Optional<Employee> op = Optional.ofNullable(new Employee("张三", 18, 888.88, Employee.Status.FREE));

        Optional<String> str = op.flatMap((e) -> Optional.of(e.getName()));
        System.out.println(str.get());
    }

}
