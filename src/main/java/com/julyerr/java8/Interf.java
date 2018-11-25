package com.julyerr.java8;

public class Interf {
    interface Defaulable {
//        可以有静态方法
        static String staticMethod() {
            return "static";
        }

//        可以有默认实现
        default String notRequired() {
            return "default";
        }
    }

    class DefaulableImpl implements Defaulable {
    }

    static class OverrideImpl implements Defaulable {
        @Override
        public String notRequired() {
            return "not Required";
        }
    }

    public static void main(String[] args) {
        Defaulable defaulable = new Interf().new DefaulableImpl();
        System.out.println(Defaulable.staticMethod());
        System.out.println(defaulable.notRequired());
        System.out.println(new OverrideImpl().notRequired());
    }
}
