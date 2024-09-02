package java.newjavaversions.java17;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RecordAndMaps {
    public record MyPair(String key, Integer value) { }

    public static void main(String[] args) {

        // Create unsorted pairs
        List<MyPair> unsortedPairs = List.of(
                new MyPair("abc", 5),
                new MyPair("xyz", 0),
                new MyPair("cde", 6)
        );

        // Sort by value using a comparator
        List<MyPair> sortedPairs = unsortedPairs
                .stream()
                .sorted(Comparator.comparing(MyPair::value))
                .collect(Collectors.toList());

// Print the sorted pairs
        sortedPairs.forEach( System.out::println);
    }
}

