package javabasics.arrays;

import util.ArrayUtil;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        Integer[] a = {20, 98, 12, 7, 35};




        //sort array
        Arrays.sort(a);
        ArrayUtil.printArray(a);

        //sort 2 D Array
        Integer[][] matrix= {{2,4}, {5,25},{4,16}};
        //sort it based on the 0th colum in ascending order

        //first way
        Arrays.sort(matrix, (x,y) -> x[0]-y[0]);
        //another way
        Arrays.sort(matrix, (x,y)-> Integer.compare(x[0],y[0]));




        for (int i = 0; i <matrix.length ; i++) {
            ArrayUtil.printArray(matrix[i]);
            System.out.println();

        }
        System.out.println("------------------");

        //sort 2d array based on Oth index, if 0th is a tie based on first index
        //e.g.
        //int[][] myMat= {{2,4}, {1,3},{2,3}};
        //should become
        //int[][] myMat= {{1,3}, {2,3},{2,4}};

        Integer[][] myMat= {{2,4}, {1,3},{2,3}};
        Arrays.sort(myMat, (x,y)-> x[0]!=y[0]? x[0]-y[0]: x[1]-y[1]);
        ArrayUtil.printArray(myMat);



    }
}
