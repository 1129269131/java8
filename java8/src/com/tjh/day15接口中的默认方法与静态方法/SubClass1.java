package com.tjh.day15接口中的默认方法与静态方法;

public class SubClass1 implements MyFun, MyInterface {
    @Override
    public String getName() {
        return MyFun.super.getName();
    }
}
