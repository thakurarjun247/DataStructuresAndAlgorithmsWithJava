package javarevision.map;

import java.util.*;
import java.util.stream.Collectors;

public class SortMapByValue {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 3);
        map.put("banana", 2);
        map.put("cherry", 5);
        map.put("durian", 1);

        Map<String, Integer> reverseValueOrder= map
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,  (e1, e2) -> e1,LinkedHashMap::new));
        System.out.println("reverse val order"+reverseValueOrder);
        reverseValueOrder.put("mango", 4);
        System.out.println("after insertion");
        //wont preserve order for new item.
        System.out.println(reverseValueOrder);


        List<Map.Entry<String, Integer>> listOfEntriesOfMap = new ArrayList<>(map.entrySet());
        Collections.sort(listOfEntriesOfMap, (x, y) -> x.getValue() - y.getValue());
        // // Create a new LinkedHashMap to preserve the order of insertion
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        listOfEntriesOfMap.forEach(item -> linkedHashMap.put(item.getKey(), item.getValue()));
        System.out.println(linkedHashMap);
    }
}
