package javabasics.collections;

import java.util.*;

public class ListOperations {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<5; i++)
            list.add(i);
        list
                .forEach(System.out::println);
    }
}
