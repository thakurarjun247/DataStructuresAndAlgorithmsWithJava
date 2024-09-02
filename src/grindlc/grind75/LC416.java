package grindlc.grind75;

import java.util.Arrays;

public class LC416 {
    public static void main(String[] args) {
        System.out.println(new LC416().canPartition(new int[]{1,5,11,5}));
    }
    public boolean canPartition(int[] a) {
        int j=a.length-2;
        if(a.length==1) return false;
        Arrays.sort(a);
        int i=1;
        int A=a[0], B=a[a.length-1];
        while(i<=j){

            if(A>B)
                B+=a[j--];
            if(B>A)
                A+=a[i++];
            if(j-i==1 && A==B)
                return true;

        }
        return false;
    }
}