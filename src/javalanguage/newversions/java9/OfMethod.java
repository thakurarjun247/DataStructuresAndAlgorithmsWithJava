package javalanguage.newversions.java9;

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

        List<Boolean> booleans= List.of(true, false); //notice the () and not [] of python
        //its a method
        //booleans.add(true);

    }
}
