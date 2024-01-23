package javarevision.map;

import java.util.*;

public class SortMapByValue {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 3);
        map.put("banana", 2);
        map.put("cherry", 5);
        map.put("durian", 1);

        List<Map.Entry<String, Integer>> newList=new ArrayList<>(map.entrySet());
        Collections.sort(newList, (x,y)->x.getValue()-y.getValue());
       // // Create a new LinkedHashMap to preserve the order of insertion
        Map<String, Integer> linkedHashMap=new LinkedHashMap<>();
        newList.forEach(item->linkedHashMap.put(item.getKey(), item.getValue()));
        System.out.println(linkedHashMap);
    }
}
