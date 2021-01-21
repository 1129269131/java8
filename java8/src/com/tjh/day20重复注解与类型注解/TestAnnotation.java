package com.tjh.day20重复注解与类型注解;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 *
 * 重复注解与类型注解
 *
 */
public class TestAnnotation {

    @Test
    public void test1() throws Exception{
        Class<TestAnnotation> clazz = TestAnnotation.class;
        Method m1 = clazz.getMethod("show");

        MyAnnotation[] mas = m1.getAnnotationsByType(MyAnnotation.class);

        for(MyAnnotation myAnnotation : mas){
            System.out.println(myAnnotation.value());
        }
    }

    /* 重复注解 */
    @MyAnnotation("Hello")
    @MyAnnotation("World")
    public void show(){

    }

    /* 类型注解 */
    public void show2(@MyAnnotation("abc") String str){

    }
}
