package java.arrays;

import java.newjavaversions.java17.RecordClassInAction;
import util.ArrayUtil;

import java.util.*;


public class Array {
    public static void main(String[] args) {
        Integer[] a = {20, 98, 12, 7, 35};

        //datastructures.array as key of a map

        Map<int[], Integer> map=new HashMap<>();
        map.put(new int[]{1,2}, 3);
        map.put(new int[]{10,20}, 30);
        //this prints false, which is incorrect
        System.out.println(map.containsKey(new int[]{1,2}));
        //instead of this, if we wrp the datastructures.array in a record, it wonm't work either.
        //see
        RecordClassInAction recordClassInAction;
        record ArrayRecord(int[] a){}
        Map<ArrayRecord,Integer> newMap= new HashMap<>();
        newMap.put(new ArrayRecord(new int[]{1,2}), 3);
        newMap.put(new ArrayRecord(new int[]{10,20}), 30);
        System.out.println(newMap.containsKey(new ArrayRecord(new int[]{1,2})));

        //It wont work
        //use this
        record MyRecord(int x, int y){}

        Set<MyRecord> recordSet= new HashSet<>();

        MyRecord record= new MyRecord(1,2);
        MyRecord anotherRecord=new MyRecord(1,2);

        System.out.println(record.equals(anotherRecord));
        System.out.println(record == (anotherRecord));

        System.out.println( recordSet.add(record));



        System.out.println(recordSet.add(anotherRecord));








        //sort datastructures.array
        Arrays.sort(a);
        ArrayUtil.printArray(a);

        //sort 2 D Array
        Integer[][] matrix= {{2,4}, {5,25},{4,16}};
        //sort it based on the 0th colum in ascending order

        //first way, asc order
        Arrays.sort(matrix, (x,y) -> x[0]-y[0]);
        //another way, asc order
        Arrays.sort(matrix, (x,y)-> Integer.compare(x[0],y[0]));




        for (int i = 0; i <matrix.length ; i++) {
            ArrayUtil.printArray(matrix[i]);
            System.out.println();

        }
        System.out.println("------------------");

        //sort 2d datastructures.array based on Oth index, if 0th is a tie based on first index
        //e.g.
        //int[][] myMat= {{2,4}, {1,3},{2,3}};
        //should become
        //int[][] myMat= {{1,3}, {2,3},{2,4}};

        Integer[][] myMat= {{2,4}, {1,3},{2,3}};




        Arrays.sort(myMat, (x,y)-> x[0]!=y[0]? x[0]-y[0]: x[1]-y[1]);
        ArrayUtil.printArray(myMat);



    }
}
