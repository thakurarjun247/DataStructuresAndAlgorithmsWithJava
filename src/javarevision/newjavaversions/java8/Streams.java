package javarevision.newjavaversions.java8;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        var list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        var evenSqured = list
                .stream()
                .map(item -> item * item)
                .filter(item -> item % 2 == 0)
                .collect(Collectors.toList());


        var sum = evenSqured.stream().mapToInt(Integer::intValue).sum();
        OptionalDouble average = evenSqured.stream().mapToInt(Integer::intValue).average();
        System.out.println(average.isPresent());

        Optional<Integer> max = evenSqured.stream().max((x, y) -> x - y);

        Integer maxValue = max.orElse(0);
        try {
            max.orElseThrow(() -> new Exception("how can it be absent"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println();


        list.parallelStream().forEach(item -> System.out.println(item + " -> " + Thread.currentThread().getName()));
        list.stream().forEach(item -> System.out.println(item + " -> " + Thread.currentThread().getName()));

        var map = Map.of(1, 10, 2, 20, 3, 30, 4, 40, 5, 50);
        //descending order of values
        var mapIndescendingOrderOfValues = map
                .entrySet()
                .stream().
                sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(mapIndescendingOrderOfValues);
        var summed = list.stream().reduce(0, (a, b) -> a + b);
        var evens = List.of(2, 4, 6, 8);
        var odds = List.of(1, 3, 5, 7);
        //return true if all of them match the criteria
        var allMatchToEven = evens.stream().allMatch(x -> x % 2 == 0);//t
        var noneMatchToEven = odds.stream().noneMatch(x -> x % 2 == 0);//t
        var anyMatchToEven = list.stream().anyMatch(x -> x % 2 == 0);//t
        //gets you a map with boolean key, key 'true'  will have the elements that match the condition, i.e. evens
        var evenOddPartitioing = list.stream().collect(Collectors.partitioningBy(item -> item % 2 == 0));
        var partitionBy3 = list.stream().collect(Collectors.partitioningBy(item -> item % 3 == 0));
        var firstEvenOptional = list.stream().filter(item -> item % 2 == 0).findFirst();
        var firstEvenValue = firstEvenOptional.orElse(-1);
        var firstEvenValueAgain = firstEvenOptional.isPresent() ? firstEvenOptional.get() : -1;
        var count = list.parallelStream().count();
        var first3ItemsOfList = list.stream().limit(3).collect(Collectors.toList());
        var skipFirst3ItemsofList = list.stream().skip(3).collect(Collectors.toList());
        //lambda

        /*
        * // Without lambda (Anonymous Class)
            Function<Integer, Integer> doubleIt1 = new Function<Integer, Integer>() {
                @Override
                public Integer apply(Integer x) {
                    return x * 2;
                }
            };

            // With Lambda
            Function<Integer, Integer> doubleIt2 = x -> x * 2;

        */
        Function<Integer, Integer> doubleIt = x -> x * 2;

        BiFunction<Integer, Integer, Integer> addIt = (m, n) -> m + n;

        System.out.println(doubleIt.apply(10));


/*

### 4️⃣ **`flatMap()` - Flattening Nested Collections**
        If you have a list of lists and need to process all elements together:
```java
        List<List<Integer>> nestedLists = List.of(List.of(1, 2, 3), List.of(4, 5, 6));
        List<Integer> flattenedList = nestedLists.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(flattenedList); // [1, 2, 3, 4, 5, 6]



### **Final Thoughts**
        You've covered the core of Java 8 Streams quite well, but adding **reduce**, **flatMap**, **grouping**, and **counting** will make your understanding even stronger. 🚀
        */
        System.out.println("end");

    }
}
