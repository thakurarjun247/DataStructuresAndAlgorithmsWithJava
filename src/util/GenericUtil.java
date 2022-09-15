package util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GenericUtil {
    public static <T> void println(T t) {
        System.out.println(t);
    }

    public static <T> void print(T t) {
        System.out.print(t);
    }

    public static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
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

    public static void printArray(int[] array) {
        if(array==null){
            System.out.println(array);
            return;
        }
        if(array.length==0 ) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < array.length-1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[array.length-1]);
        System.out.print("]");
        System.out.println("");
    }

    public static <T> void printArray(T[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println("");
    }

    public static <T> T[] swapArrayElements(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        return a;
    }

    public static boolean isStringNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public static Integer getMinFromArrays(Set<int[]> arrays) {
        //arrays.forEach(item-> item[0]=1);
        int min = Integer.MAX_VALUE;
        int minIndex=-1;
        for (int[] array : arrays) {
            int minInCurrentArray = Arrays
                    .stream(array)
                    .min()
                    .getAsInt();
            min = Math.min(min, minInCurrentArray);
        }
        return min;
    }
}
