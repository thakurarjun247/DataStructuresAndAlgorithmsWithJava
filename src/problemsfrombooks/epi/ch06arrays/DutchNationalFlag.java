package problemsfrombooks.epi.ch06arrays;


//todo: revise

import java.util.Arrays;

import static util.GenericUtil.swap;

public class DutchNationalFlag {
    public static void main(String[] args) {
        int[] a = {1, 0, 2, 1, 1, 0, 0, 2, 1, 1, 0, 0, 2, 1, 1, 0, 0, 2, 1, 1, 0, 2, 1, 0, 2, 1,};
        dnf(a, 1);
        System.out.println(Arrays.toString(a));
        ;
    }

    static void dnf(int[] a, int pivot) {
        int low = 0;
        int counter = 0;
        //we don't use mid

        int high = a.length - 1;
        while (counter < high) {
//pivot is mid item i.e. 1 in this case
            if (a[counter] < pivot) {
                swap(a, counter++, low++);
                //swap is a must here
                //consider counter=6 in below array
                // [0, 0, 0, 1, 1, 1, 0, 2, 2, 2]
            } else if (a[counter] == pivot)
                counter++;
            else// if(a[counter] > pivot)
            {
                swap(a, high--, counter);
                //don't increase the count we need to examine the one that is here
                //after swapping
            }


        }

    }
}
