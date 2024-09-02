package datastructuresandalgorithms.arraystring.fun;

import java.util.Arrays;

public class DutchNationalFlag {

    public static void dnf(Integer[] a) {
        int low = 0;
        int mid = 0;
        int counter = 0;
        int high = a.length - 1;

        while (counter <= high) {
            switch (a[counter]) {
                case 1:
                    swap(a, low++, counter++);
                    break;

                case 2:
                    mid++;
                    counter++;
                    break;

                case 3:
                    swap(a, high--, counter);
                    break;
            }
        }

    }

    public static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        char[] array = {'a', 'b', 'c'};
        System.out.println("Arrays.toString(datastructures.array)" + Arrays.toString(array));
        System.out.println("String.valueOf(datastructures.array)" + String.valueOf(array));
        Arrays.sort(array);
        System.out.println(array);
        Integer[] a = {2,3,1,2,2,1,3};
        DutchNationalFlag.dnf(a);
        System.out.println(Arrays.toString(a));
        Integer arr[] = { 1, 1, 1, 2,  3};
        DutchNationalFlag.dnf(arr);
        System.out.println(Arrays.toString(arr));

    }

}