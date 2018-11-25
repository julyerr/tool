package com.julyerr.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Ref {
    public Ref() {
    }

    public static Ref create(final Supplier<Ref> supplier) {
        return supplier.get();
    }

    public static void collide(final Ref Ref) {
        System.out.println("Collided " + Ref.toString());
    }

    public void follow(final Ref another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

    public static void main(String[] args) {
//        构造方法
        final Ref ref = create(Ref::new);
        List<Ref> refs = Arrays.asList(ref);
//        静态方法
        refs.forEach(Ref::collide);
//        成员方法，不接受参数
        refs.forEach(Ref::repair);
//        实例方法，只接受一个参数
        refs.forEach(ref::follow);
    }
}
