package javarevision.newjavaversions.java8;

import datastructures.arraystring.fun.Basic;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        var list=List.of(1,2,3,4,5,6,7,8,9);
        var evenSqured=list
                .stream().map(item-> item*item)
                .filter(item-> item%2==0)
                .collect(Collectors.toList());

        System.out.println(evenSqured);
        var sum=evenSqured.stream().mapToInt(Integer::intValue).sum();
        OptionalDouble average=evenSqured.stream().mapToInt(Integer::intValue).average();
        System.out.println(average.isPresent());

        Optional<Integer> max=evenSqured.stream().max((x, y)->x-y);

        Integer maxValue=max.orElse(0);
        try {
            max.orElseThrow(()->new Exception("how can it be absent"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println();


        list.parallelStream().forEach(item->System.out.println(item+" -> "+Thread.currentThread().getName()));
        list.stream().forEach(item->System.out.println(item+" -> "+Thread.currentThread().getName()));

        var map=Map.of(1,10,2,20,3,30,4,40,5,50);
        //descending order of values
        var mapIndescendingOrderOfValues=map
                .entrySet()
                .stream().
                sorted((e1,e2)->e2.getValue()-e1.getValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(mapIndescendingOrderOfValues);
        var summed=list.stream().reduce(0,(a, b)-> a+b);
        var evens=List.of(2,4,6,8);
        var odds=List.of(1,3,5,7);
        //return true if all of them match the criteria
        var allMatchToEven=evens.stream().allMatch(x->x%2==0);//t
        var noneMatchToEven=odds.stream().noneMatch(x->x%2==0);//t
        var anyMatchToEven=list.stream().anyMatch(x->x%2==0);//t
        System.out.println("end");

/*

        ---



        ---

### 2️⃣ **`allMatch()`, `anyMatch()`, `noneMatch()` - Checking Conditions**
        These help when you need to check whether elements satisfy certain conditions.
```java
        boolean allEven = list.stream().allMatch(num -> num % 2 == 0);
        boolean anyEven = list.stream().anyMatch(num -> num % 2 == 0);
        boolean noneNegative = list.stream().noneMatch(num -> num < 0);
```

        ---

### 3️⃣ **Grouping and Partitioning Using Collectors**
        You can use `Collectors.groupingBy()` to classify elements into categories.
```java
        Map<Boolean, List<Integer>> evenOddPartition = list.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(evenOddPartition);
```
        or group by number categories:
```java
        Map<Integer, List<Integer>> groupedByRemainder = list.stream()
                .collect(Collectors.groupingBy(n -> n % 3));
        System.out.println(groupedByRemainder);
```

        ---

### 4️⃣ **`flatMap()` - Flattening Nested Collections**
        If you have a list of lists and need to process all elements together:
```java
        List<List<Integer>> nestedLists = List.of(List.of(1, 2, 3), List.of(4, 5, 6));
        List<Integer> flattenedList = nestedLists.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(flattenedList); // [1, 2, 3, 4, 5, 6]
```

        ---

### 5️⃣ **Finding First Element with `findFirst()` and `findAny()`**
```java
        Optional<Integer> firstEven = list.stream().filter(n -> n % 2 == 0).findFirst();
        Optional<Integer> anyEven = list.parallelStream().filter(n -> n % 2 == 0).findAny();
```
        - `findFirst()` guarantees the first element in sequence.
        - `findAny()` is optimized for parallel execution and returns any matching element.

                ---

### 6️⃣ **Counting Elements Using `count()`**
        Instead of collecting into lists, just count occurrences:
```java
        long evenCount = list.stream().filter(n -> n % 2 == 0).count();
        System.out.println("Even numbers count: " + evenCount);
```

        ---

### 7️⃣ **Skipping and Limiting Elements (`skip()` and `limit()`)**
        If you want to process only a subset of the stream:
```java
        List<Integer> limited = list.stream().limit(3).collect(Collectors.toList()); // First 3 elements
        List<Integer> skipped = list.stream().skip(3).collect(Collectors.toList()); // Skip first 3 elements
```

        ---

### **Extra: Minor Fixes**
🔹 **Use `Comparator.comparing()` Instead of Custom Lambda for Sorting**
```java
        var sortedByValuesDesc = map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
```
        More concise and avoids potential integer overflow issues in subtraction.

        ---

### **Final Thoughts**
        You've covered the core of Java 8 Streams quite well, but adding **reduce**, **flatMap**, **grouping**, and **counting** will make your understanding even stronger. 🚀
        */


    }
}
