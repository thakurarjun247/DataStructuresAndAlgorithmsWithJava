package javarevision.newjavaversions.java8;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
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
        OptionalDouble average=evenSqured.stream().mapToInt(Integer::intValue).average();
        System.out.println(average.isPresent());

        Optional<Integer> max=evenSqured.stream().max((x, y)->x-y);
        max.isPresent()
        Integer maxValue=max.orElse(0);
        try {
            max.orElseThrow(()->new Exception("how can it be absent")); 
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println();
    }
}
