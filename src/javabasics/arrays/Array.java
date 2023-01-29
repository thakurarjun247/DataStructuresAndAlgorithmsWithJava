package javabasics.arrays;

import java.util.Arrays;
import java.util.Collections;

public class Array {
    public static void main(String[] args) {
        int[] a = {20, 98, 12, 7, 35};

        int min = Arrays
                .stream(a)
                .min()
                .getAsInt();
        System.out.println(min);

        //sort array
        Arrays.sort(a);
        util.GenericUtil.printArray(a);

        //sort 2 D Array
        int[][] matrix= {{2,4}, {5,25},{4,16}};
        //sort it based on the 0th colum in ascending order
        Arrays.sort(matrix, (x,y) -> x[0]-y[0]);
        for (int i = 0; i <matrix.length ; i++) {
            util.GenericUtil.printArray(matrix[i]);
            System.out.println();

        }
    }
}
