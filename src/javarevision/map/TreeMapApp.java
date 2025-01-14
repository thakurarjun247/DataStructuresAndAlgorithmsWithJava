package javarevision.map;

import javarevision.collections.records.Plant;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMapApp {
    public static void main(String[] args) {


        Map<Plant, Integer> map = new TreeMap<>();
        Plant rose = new Plant("red", 121);
        Plant cactus = new Plant("green", 12);


        Plant aloevera = new Plant("navygreen", 880);
        //it will lead to class cast exception at run time

//        map.put(cactus,1);
//        map.put(rose,2);
//        System.out.println(map);

        //if comparator not passed in the args of treeset here,
        //it will blow up at run time, in the line number where a value is added to it
        //unfortunately, no compile time check for it.
        Set<Plant> sortedSetDescOrderOfHeight=new TreeSet<>((x,y)->y.height()-x.height());
        sortedSetDescOrderOfHeight.add(rose);
        sortedSetDescOrderOfHeight.add(cactus);
        sortedSetDescOrderOfHeight.add(aloevera);
        System.out.println(sortedSetDescOrderOfHeight);
        Map<Plant, Integer> mapWithComparator = new TreeMap<>((p1, p2) -> p1.color().compareTo(p2.color()));
        mapWithComparator.put(cactus, 1);
        mapWithComparator.put(rose, 2);
        System.out.println(mapWithComparator);


    }
}
