package javarevision.map;

import javarevision.collections.records.Plant;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapApp {
    public static void main(String[] args) {


        Map<Plant, Integer> map = new TreeMap<>();
        Plant cactus = new Plant("green", 12);

        Plant rose = new Plant("red", 121);
        Plant aloevera = new Plant("navygreen", 880);
        //it will lead to class cast exception at run time

//        map.put(cactus,1);
//        map.put(rose,2);
//        System.out.println(map);


        Map<Plant, Integer> mapWithComparator = new TreeMap<>((p1, p2) -> p1.color().compareTo(p2.color()));
        mapWithComparator.put(cactus, 1);
        mapWithComparator.put(rose, 2);
        System.out.println(mapWithComparator);


    }
}
