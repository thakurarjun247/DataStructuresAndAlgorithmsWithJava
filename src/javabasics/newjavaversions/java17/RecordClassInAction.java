package javabasics.newjavaversions.java17;

import java.util.*;

public class RecordClassInAction {
    public static void main(String[] args) {
        //arrange them in ascending order of names.
        Map<MyRecordClass, Integer> map= new TreeMap<>((x, y)->x.name().compareTo(y.name()));
        map.put(new MyRecordClass("A", 1), 100);
        map.put(new MyRecordClass("Z", 0), 300);
        map.put(new MyRecordClass("B", 2), 200);
        System.out.println(map.containsKey(new MyRecordClass("A", 1)));
        map
                .forEach((k,v)-> System.out.println(k+" -> "+v));

        //ascending order of age
        Map<MyRecordClass, Integer> map1= new TreeMap<>((x, y)->x.age()-y.age());
        map1.putAll(map);
        map1
                .forEach((k,v)-> System.out.println(k+" -> "+v));
    }
}
