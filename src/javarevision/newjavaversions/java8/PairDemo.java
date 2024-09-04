package javarevision.newjavaversions.java8;

///import javafx.util.Pair;
//import datastructures.arraystring.fun.Pair;


import util.Pair;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//Java 9 pair, like a SCALA tuple


public class PairDemo {

    //use records instead
    public static void main(String[] args) {
        Pair<Integer, String> one = new Pair<>(1, "one");
        Pair<Integer, String> zero = new Pair<>(0, "zero");
        Pair<Integer, String> two = new Pair<>(2, "two");
        List<Pair<Integer, String>> list = Arrays.asList(one, zero, two);
        list.forEach(item -> System.out.println(item.getKey() + " " + item.getValue()));
        Collections.sort(list, (p1, p2) -> p1.getKey() - p2.getKey());
        list.forEach(item -> System.out.println(item.getKey() + " " + item.getValue()));

        System.out.println(one);
    }


}

