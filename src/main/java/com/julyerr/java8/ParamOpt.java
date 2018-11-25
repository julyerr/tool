package com.julyerr.java8;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Optional;

public class ParamOpt {
    public static void main(String[] args) throws NoSuchMethodException {
//        字节码中获取方法参数的名称
        Method method = ParamOpt.class.getMethod("main", String[].class);
        for (final Parameter parameter : method.getParameters()) {
            System.out.println("Parameter:" + parameter.getName());
        }

//        optional 关键字的使用
        Optional<String> optionalNull = Optional.ofNullable(null);
        System.out.println("set?" + optionalNull.isPresent());
        System.out.println(optionalNull.orElseGet(() -> "none"));
        System.out.println(optionalNull.map(e -> "hey! " + e).orElse(" hey! none"));

        Optional<String> optional = Optional.ofNullable("name");
        System.out.println("set?" + optional.isPresent());
        System.out.println(optional.orElseGet(() -> "none"));
        System.out.println(optional.map(e -> "hey! " + e).orElse(" hey! none"));
    }
}

