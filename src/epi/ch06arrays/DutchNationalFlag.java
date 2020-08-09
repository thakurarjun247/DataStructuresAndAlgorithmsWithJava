package epi.ch06arrays;


//todo: revise
import util.Util;

import java.util.Arrays;

import static util.Util.swap;

public class DutchNationalFlag {
    public static void main(String[] args) {
        int[] a = {1, 0, 2, 1, 1};
        dnf(a, 1);
        System.out.println(Arrays.toString(a));;
    }

    static void dnf(int[] a, int pivot) {
        int low, mid, counter, high;
        low = mid = counter = 0;

        high = a.length;//notice it's not len-1
        while (counter < high) {

            if (a[counter] < pivot) {
                swap(a, counter++, low++);
                //swap is a must here
                //consider counter=6 in below array
                // [0, 0, 0, 1, 1, 1, 0, 2, 2, 2]
            } else if (a[counter] == pivot)
                counter++;
            else// (a[counter] > pivot)
            {
                swap(a, --high, counter);
                //don't increase the count we need to examine the one that is here
                //after swapping
            }


        }

    }
}
