package arraystring.fun;

import java.util.Arrays;

public class DutchNationalFlag {

    public static void dnf(Integer[] a) {
        int low = 0;
        int high = a.length - 1;
        int mid = 0;
        int i = 0;
        while (i <= high) {
            switch (a[i]) {
                case 1:
                    swap(a, low++, i++);
                    break;

                case 2:
                    mid++;
                    i++;
                    break;

                case 3:
                    swap(a, high--, i);
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
        System.out.println("Arrays.toString(array)" + Arrays.toString(array));
        System.out.println("String.valueOf(array)" + String.valueOf(array));
        Arrays.sort(array);
        System.out.println(array);
        Integer[] a = {3,1,2,2,1};
        DutchNationalFlag.dnf(a);
        System.out.println(Arrays.toString(a));
        Integer arr[] = { 1, 1, 1, 2,  3};
        DutchNationalFlag.dnf(arr);
        System.out.println(Arrays.toString(arr));

    }

}