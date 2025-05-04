package javalanguage.fundamentals.collections.records;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecordComparatorComparable {
    public static void main(String[] args) {
        Plant cactus = new Plant("green", 12);

        Plant rose = new Plant("red", 121);
        Plant aloevera = new Plant("navygreen", 880);


        //you can't sort the below list, it's immutable;
        List<Plant> plants = List.of(cactus, rose, aloevera);

        List<Plant> anotherList = new ArrayList<>(plants);
        Collections.sort(anotherList, (p1, p2) -> p1.color().compareTo(p2.color()));
        System.out.println(anotherList);

        Collections.sort(anotherList, (p1, p2) -> p1.height() - p2.height());
        System.out.println(anotherList);

    }
}
