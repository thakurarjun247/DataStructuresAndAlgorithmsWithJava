package datastructures.arraystring.ch06arrays;

import java.util.ArrayList;
import java.util.*;

public class ArbitaryPrecision {
    public static void main(String[] args) {
        int a[]={1,0};
        int b[]={9,9};
        int c[]={0};
        int d[]={1,2,3};
        f(a);
        f(b);
        f(c);
        f(d);

    }
    static void f(int[] a){
        //keep size, one more than the datastructures.array to hold any carry/overflow
        //following is wrong, it will set capacity not size.
        // List<Integer> list= new ArrayList<>(a.length+1);
       // System.out.println(list.size());


        List<Integer> list= new ArrayList<>();
        //set 0th element as 0


        //this is wrong, you can't set anything in a list of size 0
         //list.set(0,0);
        list.add(0);
        for(int i=0;i<a.length;i++){
            list.add(a[i]);
        }
         //we are adding 1 to the number hence carry will be 1 initiallay
        int carry=1;
        //leave the most significant for now, will process later.
        for(int i=list.size()-1;i>0;i--){
            int digit=list.get(i);
            int sum=digit+carry;
            int thisItem=sum%10;
            carry=sum/10;
            list.set(i, thisItem);

        }
        list.set(0,carry);

        System.out.println(Arrays.toString(a));
        System.out.println(list);
        System.out.println("-------------------------");
    }
}
