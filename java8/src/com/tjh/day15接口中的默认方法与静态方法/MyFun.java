package com.tjh.day15接口中的默认方法与静态方法;

public interface MyFun {

    default String getName(){
        return "哈哈哈";
    }

}
