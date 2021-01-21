package com.tjh.day15接口中的默认方法与静态方法;

public class TestDefaultInterface {

    /* 类优先原则 */
    public static void main(String[] args) {
        SubClass sc = new SubClass();
        System.out.println(sc.getName());

        System.out.println("------华丽的分割线------");

        SubClass1 sc2 = new SubClass1();
        System.out.println(sc2.getName());

        System.out.println("------华丽的分割线------");

        MyInterface.show();
    }

}
