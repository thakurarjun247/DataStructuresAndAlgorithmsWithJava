package javalanguage.fundamentals.map;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupNumbersAndPutToMap {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Map<Boolean, List<Integer>> map=Arrays.stream(numbers).boxed().collect(Collectors.partitioningBy(n->n%2==0));
        System.out.println(map.get(true));
        System.out.println(map.get(false));
// Group by remainder when divided by 3 (i.e., 0, 1, 2)
        Map<Integer, List<Integer>> groupedByModulo3 = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.groupingBy(n -> n % 3));

        // Print the groups
        groupedByModulo3.forEach((key, value) ->
                System.out.println("Remainder " + key + ": " + value)
        );

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