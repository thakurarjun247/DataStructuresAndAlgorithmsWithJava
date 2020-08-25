package javabasics.collections;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[] a = {20, 98, 12, 7, 35};

        int min = Arrays
                .stream(a)
                .min()
                .getAsInt();
        System.out.println(min);
    }
}
