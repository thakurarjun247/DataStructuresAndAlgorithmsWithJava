package javalanguage.fundamentals.map;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class MapOperations {
    public static void main(String[] args) {
        Map<Integer, String> numberToWords = new HashMap<>();
        numberToWords.put(0, "zero");
        numberToWords.put(1, "one");
        numberToWords.put(2, "two");
        numberToWords.put(3, "three");
        numberToWords.put(4, "four");
        numberToWords.put(5, "five");

        numberToWords.forEach((k,v)->{
            System.out.print(v);
        });

        //iterate
        //notice single arrow -> not double
        numberToWords.forEach((k, v) -> System.out.println(k + "->" + v));

        //This should be used when we are planning on doing some additional Stream processing.
        // Otherwise, it's just a simple forEach() as described previously.


        //transform
        System.out.println("transform...");
        numberToWords
                .entrySet()
                .stream()
                .collect(Collectors.toMap(e->e.getKey()*e.getKey(), e->e.getValue()+e.getValue(), (a,b)->a, LinkedHashMap::new ));
        //another way
        Map<Integer, String> squreMaps = numberToWords
                .entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getKey() * e.getKey(), e -> e.getValue() + e.getValue()));

        numberToWords
                .entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
        List<Integer> list = numberToWords.keySet().stream().collect(Collectors.toList());
        System.out.println(list
        );
        System.out.println(squreMaps);


        //filter, only retain the value five

        numberToWords
                .entrySet()
                .stream()
                .filter(entrySet -> entrySet.getKey() == 5)
                .forEach(e -> System.out.println(e.getKey() + "->" + e.getValue()));
        //there is nothing called filter not


        Map<Integer, Integer> numberTo2xNumber = numberToWords
                .entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getKey() * 2));

        //notice the keyset and values are collections hence these ops are applicable on collections as well
        int sumOfKeys = numberTo2xNumber.keySet().stream().reduce(0, Integer::sum);
        int sumOfValues = numberTo2xNumber.values().stream().reduce(0, Integer::sum);

        System.out.println(sumOfKeys + " " + sumOfValues);
        var integers=List.of(1,2,3,4,5);
        var max=integers.stream().reduce(0, Integer::max);
        var sum=integers.stream().reduce(0, Integer::sum);
        var sortedDesc=integers.stream().sorted((x,y)->y-x).collect(Collectors.toList());
        System.out.println("max and sum for the "+integers+" are: "+max+", "+sum);
        System.out.println("sorted in desc order: "+sortedDesc);

        //sort map in descending order of values


//        .sorted(comparingByValue())


        Map<Integer, Integer> ascendingOrderOfMapValues = numberTo2xNumber
                .entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
//sort by keys
        //  int[] sorted = numberTo2xNumber
        //     .entrySet().toArray();


        ascendingOrderOfMapValues.forEach((k, v) -> System.out.println(k + "->" + v));
        Map<Integer, Integer> reverseOrderOfMapValues = numberTo2xNumber
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        reverseOrderOfMapValues.forEach((k, v) -> System.out.println(k + "->" + v));

    }
}
