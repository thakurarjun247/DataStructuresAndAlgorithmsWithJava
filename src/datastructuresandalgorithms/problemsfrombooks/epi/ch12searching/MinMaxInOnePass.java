package datastructuresandalgorithms.problemsfrombooks.epi.ch12searching;

import java.util.Arrays;
import java.util.Random;

public class MinMaxInOnePass {


    public static void main(String[] args) {
        Random r = new Random();
        int[] a = new int[10];
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 5; i++) {
                a[i] = r.nextInt(4);
            }
            System.out.println("actual: " + Arrays.toString(a));

            System.out.println(f(a).max + " " + f(a).min);
        }
    }

    static class MinMax {
        int min, max;
        MinMax(){}
        MinMax(int min, int max){
            this.min=min;
            this.max=max;
        }

    }

    static MinMax f(int[] a) {
        MinMax mm=new MinMax();
        if(a.length==0) return mm;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int low = 0;
        int high = a.length - 1;
        int i = 0;
        while (low < high) {
            int x = a[low];
            int y = a[high];
            if (x > y) {
                if (min > y)
                    min = y;
                else if (max < x)
                    max = x;
            } else {
                if (min > x)
                    min = x;
                else if (max < y)
                    max = y;
            }
            low++;
            high--;
        }
        if (a.length % 2 != 0)
            if (a[low] > max)
                max = a[low];
        if (a[low] < min)
            min = a[low];
        return new MinMax(min, max);

    }
}
