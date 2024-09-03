package javarevision.map;

import java.util.HashMap;
import java.util.Map;

public class MapEquality {
    public static void main(String[] args) {
        Map<Integer, String> map1=new HashMap<>();

        Map<Integer, String> map2=new HashMap<>();
        map1.put(1, "one");
        map1.put(1, "one");
        System.out.println(map1.equals(map2));
        map2.put(1, "one");
        System.out.println(map1.equals(map2));
    }
}
