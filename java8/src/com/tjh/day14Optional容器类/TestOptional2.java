package com.tjh.day14Optional容器类;

import org.junit.Test;

import java.util.Optional;

public class TestOptional2 {

    // 需求：获取一个男人心中女神的名字
    /* 普通实现 */
    @Test
    public void test1(){
        Man man = new Man();

        String name = getGodnessName(man);
        System.out.println(name);
    }

    public String getGodnessName(Man man){
        if(man != null){
            Godness g = man.getGod();

            if(g != null){
                return g.getName();
            }
        }

        return "苍老师";
    }

    /* 使用Optional实现 */
    @Test
    public void test2(){
        Optional<Godness> gn = Optional.ofNullable(new Godness("波多老师"));
        Optional<NewMan> op = Optional.ofNullable(new NewMan(gn));
        String str = getGodnessName2(op);
        System.out.println(str);
    }

    public String getGodnessName2(Optional<NewMan> man){
        return man.orElse(new NewMan())
                .getGodness()
                .orElse(new Godness("苍老师"))
                .getName();
    }

}
