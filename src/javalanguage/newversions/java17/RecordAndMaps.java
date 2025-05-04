package javalanguage.newversions.java17;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RecordAndMaps {
    public record MyRecord(String key, Integer value) {
    }
    public static void main(String[] args) {

        // Create unsorted pairs
        List<MyRecord> myRecordList = List.of(
                new MyRecord("abc", 5),
                new MyRecord("xyz", 0),
                new MyRecord("cde", 6)
        );



        System.out.println("desc order");

        myRecordList
                .stream()
                .sorted((r1,r2)->r2.value()-r1.value())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        myRecordList
                .stream()
                .sorted((r1,r2)->r2.value-r1.value)
                .collect(Collectors.toList())
                .forEach(System.out::println);


        // Sort by value using a comparator
        List<MyRecord> sortedPairs = myRecordList
                .stream()
                .sorted(Comparator.comparing(MyRecord::value))
                .collect(Collectors.toList());

// Print the sorted pairs
        sortedPairs.forEach(System.out::println);
    }


}

