package problemsfrombooks.epi.ch06arrays;

import java.util.Arrays;

public class BuySellStocks {
    public static void main(String[] args) {
        int a[] = {310,315,275,295,260,270,290,230,255,250};
        int b[]={100, 180, 260, 310, 40, 535, 695};
   f(a);
   f(b);
    }

    static void f(int[] a) {
        //calculate diff of price of this day vs yesterday.
        //find the max subarray

        for (int i = a.length-1; i >0; i--) {
            a[i] = a[i]-a[i - 1];
        }
        a[0] = 0;
        System.out.println(Arrays.toString(a));
        System.out.println("buy sell once: " + buySellOnce(a));
        System.out.println("buy sell n times"+ buySellAnyNumberOfTimesButMaximizeProfit(a));
    }

    private static int buySellOnce(int[] a) {
        //kadanes algo
        int localMax = Integer.MIN_VALUE;
        int globalMax = 0;
        for (int i = 0; i < a.length; i++) {
            localMax = Math.max(localMax, 0 )+ a[i];
            globalMax = Math.max(localMax, globalMax);
        }
        return globalMax;
    }
    //If we can buy sell n times just some all the items in diff array
    private static int buySellAnyNumberOfTimesButMaximizeProfit(int[] a) {
        //just sum them all in the diff array
     int sum=0;
        for (int i = 0; i < a.length; i++) {
            if(a[i]>0)
                sum+=a[i];
        }
        return sum;
    }
}
