package javarevision.newjavaversions.java9;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OfMethod {
    public static void main(String[] args) {

        List<String> fruits = List.of("apple", "banana", "orange"); // Immutable list
        Set<Integer> numbers = Set.of(1, 2, 3, 4); // Immutable set with duplicates removed
        Map<String, Integer> ages = Map.of("John", 30, "Mary", 25); // Immutable map
        // Adding elements after creation throws an UnsupportedOperationException.

        System.out.println(fruits);
        //this will blast
        // fruits.add("bomb");

        // encode decode tree in codeonline.leetcode
        List<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(100);
        integerArrayList.add(null);
        integerArrayList.add(200);

        String encodedString = integerArrayList.toString();

        String[] extractedNumbersInStringFormat = encodedString
                .substring(1, encodedString.length() - 1)
                .split(", ");

        List<Integer> decodedIntegerList = new ArrayList<>();

        for (String s : extractedNumbersInStringFormat)
            decodedIntegerList.add(Integer.parseInt(s));
        System.out.println(decodedIntegerList);


    }
}
