package java.collections;

import java.util.*;

public class ListOperations {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<5; i++)
            list.add(i);
        System.out.println(list);
        list.add(2,200);
        System.out.println(list);

        list
                .forEach(System.out::println);
        List<Integer> marks= Arrays.asList(1,2,3);
        //average of list

        //reverse a list, returns void
        Collections.reverse(list);

        Double average = marks
                .stream()
                .mapToDouble(a -> a)
                .average()
                .getAsDouble();
        System.out.println(average);

        //compare two lists
        List<Integer> list1= Arrays.asList(1,2,3);
        List<Integer> list2= Arrays.asList(1,2,4);
        List<Integer> list3= Arrays.asList(3,2,1);
        System.out.println(list1.equals(list2));
        System.out.println(list1.equals(list3));
        Collections.sort(list1);
        Collections.sort(list3);
        System.out.println(list1.equals(list3));


    }
}
