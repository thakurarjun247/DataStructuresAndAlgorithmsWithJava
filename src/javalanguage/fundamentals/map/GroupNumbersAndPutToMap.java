package javalanguage.fundamentals.map;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupNumbersAndPutToMap {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        Map<String, List<Integer>> groupedNumbers = groupByMultipleOfThree(numbers);

        System.out.println("Grouped numbers:");
        groupedNumbers.forEach((key, value) -> System.out.println(key + " -> " + value));
    }

    public static Map<String, List<Integer>> groupByMultipleOfThree(int[] numbers) {
        return Arrays.stream(numbers)
                .boxed()//boxing to Integers
                .collect(Collectors.partitioningBy(n -> n % 3 == 0))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey() ? "multiple of 3" : "not multiple of 3",
                        Map.Entry::getValue
                ));
    }
}