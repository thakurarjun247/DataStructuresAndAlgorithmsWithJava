package javabasics.map;

import java.util.*;
import java.util.stream.Collectors;

public class MapOperations {
    public static void main(String[] args) {
        Map<Integer, String> numberToWords = new HashMap<>();
        numberToWords.put(0, "zero");
        numberToWords.put(1, "one");
        numberToWords.put(2, "two");
        numberToWords.put(3, "three");
        numberToWords.put(4, "four");
        numberToWords.put(5, "five");

        //iterate
        //notice single arrow -> not double
        numberToWords.forEach((k, v) -> System.out.println(k + "->" + v));

        //This should be used when we are planning on doing some additional Stream processing.
        // Otherwise, it's just a simple forEach() as described previously.
        numberToWords.entrySet().stream().forEach(entrySet -> System.out.println(entrySet.getKey() + "->" + entrySet.getValue()));


        //transform
        System.out.println("transform...");

        numberToWords
                .entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getKey() * 2, e -> e.getValue() + e.getValue()))
                .forEach((k, v) -> System.out.println(k + "->" + v));


        //filter, only retain the value five

        numberToWords
                .entrySet()
                .stream()
                .filter(entrySet-> entrySet.getKey()==5)
                .forEach(e -> System.out.println(e.getKey() + "->" + e.getValue()));
      //there is nothing called filter not


        Map<Integer, Integer> numberTo2xNumber=numberToWords
                .entrySet()
                .stream()
                .collect(Collectors.toMap(e->e.getKey(), e-> e.getKey()*2));
        int sumOfKeys = numberTo2xNumber.keySet().stream().reduce(0, Integer::sum);
        int sumOfValues=numberTo2xNumber.values().stream().reduce(0 ,Integer::sum );
        System.out.println(sumOfKeys+" "+sumOfValues);

    }
}
