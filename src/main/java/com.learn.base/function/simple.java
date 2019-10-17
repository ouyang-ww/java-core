package com.learn.base.function;

import java.util.ArrayList;
import java.util.List;

public class simple {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a1");
        list.add("a2");
        list.add("a3");
        list.add("a4");
        list.add("a5");


        list.stream().filter(v -> v.startsWith("a")).map(v -> new String[]{v}).forEach(System.out::println);

        //lambda expression can implement a interface which have only one abstract interface method
        TestFunctional tf = v -> v;
        TestFunctional tf2 = (int v) -> v + 1;
        TestFunctional tf3 = (int v) ->{ v ++; return v * 2;};
        TestFunctional tf4 = Math::abs;

        System.out.println("tf:" + tf.doubleAdd(4));
        System.out.println("tf2:" + tf2.add(4));
        System.out.println("tf3:" + tf3.add(4));
    }

    /**
     * in java8, interface has an important change:interface can define a default method
     * just like the following doubleAdd method, this change enhanced the interface and extend the function
     * but if a class implements two interface that have a same default key word method, the class must rewrite the method to avoid diamond problem.
     */
    interface TestFunctional {

        int add(int v);

        default int doubleAdd(int v){
            return add(v) + v;
        }
    }
}
