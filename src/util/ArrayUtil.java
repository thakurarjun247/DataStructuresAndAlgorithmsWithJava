package util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ArrayUtil {

    public static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }



    public static int[] generateArray() {
        return generateArray(10, false, 9, false);
    }

    public static int[] generateArray(Integer arraySize, Boolean negativesAllowed, Integer upperBound, Boolean uniqueNumbers) {
        Random random = new Random();
        Set<Integer> set = new HashSet<>();
        int[] a = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            a[i] = random.nextInt(10) - (negativesAllowed ? 2 : 0);
        }
        return a;

    }


    public static void printArray(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println("");
    }



    public static <T> void printArray(T[] array) {
        //this function works exactly as
        //System.out.println(Arrays.toString(datastructures.array));
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if(i== array.length-1)
                continue;
            System.out.print(", ");
        }
        System.out.print("]");
        System.out.println("");

    }
    public static <T> void printArray(T[][] array) {
        for (T[] row:array) {
            printArray(row);
        }
        System.out.println("");
    }

    public static <T> T[] swapArrayElements(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        return a;
    }




}
