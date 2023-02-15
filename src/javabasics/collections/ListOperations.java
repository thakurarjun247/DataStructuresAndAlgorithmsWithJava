package javabasics.collections;

import java.util.*;

public class ListOperations {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<5; i++)
            list.add(i);
        list
                .forEach(System.out::println);
        List<Integer> marks= Arrays.asList(1,2,3);
        //average of list
        Double average = marks
                .stream()
                .mapToDouble(a -> a)
                .average()
                .getAsDouble();
        System.out.println(average);

    }
}
