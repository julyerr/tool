package com.julyerr.java8;

import java.util.ArrayList;
import java.util.List;

public class LambInter {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");

//        类的成员变量或者局部变量会转换为final类型
        String separator = ",";
        list.forEach(e -> System.out.println(e + separator));
        new LambInter().new FunctionalDefaultClass().method();
    }

    @FunctionalInterface
//    起到注解的作用
    public interface FunctionalDefaultMethods {
        void method();
    }

    class FunctionalDefaultClass implements FunctionalDefaultMethods {

        @Override
        public void method() {
            System.out.println("default class");
        }
    }
}
