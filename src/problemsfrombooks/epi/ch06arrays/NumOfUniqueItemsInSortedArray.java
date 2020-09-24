package problemsfrombooks.epi.ch06arrays;

import java.util.Arrays;

public class NumOfUniqueItemsInSortedArray {
    public static void main(String[] args) {
        Integer b[]={0,0, 1,2,2,2,3,9,9};
        System.out.println(f(b));;
    }
    //time complexity should be linear, no extra space.
    static int f(Integer a[]){
        if(a.length==0) return 0;
        int compareWithIndex=0;
        for(int i=1;i<a.length;i++)
        {
            if(a[i]==a[compareWithIndex]){
                a[i]=null;
            }
            else{
                compareWithIndex=i;
            }
        }
        System.out.println(Arrays.toString(a));
       /* int nullIndex=-1;
        int current=0;
        while(current<a.length){
            if(a[current]==null) {
                nullIndex = current;
                current++;
            }
            if(nullIndex>=0 && nullIndex<current){
                //set current pos to null so that it can be filled later.
                a[nullIndex]=a[current];
                a[current]=null;
               current++;
            }
        }
        System.out.println(Arrays.toString(a));
*/
        int ans=a.length;
        for(int i=0;i<a.length;i++)

            if(a[i]==null)
                ans -=1;
        return ans;

    }
}
