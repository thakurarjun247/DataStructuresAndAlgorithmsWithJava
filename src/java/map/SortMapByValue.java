package java.map;

import java.util.*;

public class SortMapByValue {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 3);
        map.put("banana", 2);
        map.put("cherry", 5);
        map.put("durian", 1);

        ;


        List<Map.Entry<String, Integer>> listOfEntriesOfMap=new ArrayList<>(map.entrySet());
        Collections.sort(listOfEntriesOfMap, (x,y)->x.getValue()-y.getValue());
       // // Create a new LinkedHashMap to preserve the order of insertion
        Map<String, Integer> linkedHashMap=new LinkedHashMap<>();
        listOfEntriesOfMap.forEach(item->linkedHashMap.put(item.getKey(), item.getValue()));
        System.out.println(linkedHashMap);
    }
}
