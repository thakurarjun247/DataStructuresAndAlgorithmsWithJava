package javarevision.newjavaversions.java17;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RecordAndMaps {
    public static void main(String[] args) {

        // Create unsorted pairs
        List<MyRecord> unsortedPairs = List.of(
                new MyRecord("abc", 5),
                new MyRecord("xyz", 0),
                new MyRecord("cde", 6)
        );

        // Sort by value using a comparator
        List<MyRecord> sortedPairs = unsortedPairs
                .stream()
                .sorted(Comparator.comparing(MyRecord::value))
                .collect(Collectors.toList());

// Print the sorted pairs
        sortedPairs.forEach(System.out::println);
    }

    public record MyRecord(String key, Integer value) {
    }
}

