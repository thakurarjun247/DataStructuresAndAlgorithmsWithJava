package javarevision.newjavaversions.java8;

import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        var list=List.of(1,2,3,4,5,6,7,8,9,0);
        var evenSqured=list
                .stream().map(item-> item*item)
                .filter(item-> item%2==0)
                .collect(Collectors.toList());

        System.out.println(evenSqured);
        var sum=evenSqured.stream().mapToInt(Integer::intValue).sum();
        var average=evenSqured.stream().mapToInt(Integer::intValue).average();
        var max=evenSqured.stream().max((x,y)->x-y);
        System.out.println();
    }
}
