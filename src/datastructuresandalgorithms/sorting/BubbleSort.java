package datastructuresandalgorithms.sorting;

//https://www.youtube.com/watch?v=p__ETf2CKY4


import util.ArrayUtil;

public class BubbleSort {
    public static void main(String[] args) {
        Integer a[]={5,4,10,3,0,1,4,4,9};
        ArrayUtil.printArray(bubbleSort(a));
    }
    public static Integer[] bubbleSort(Integer[] a){
        if(a.length<2)
            return a;
        for (int i = 0; i < a.length; i++) { //just to count the number of passes

            for (int j = 1; j < a.length-i; j++) {
                int keyIndex=j-1;
                if(a[keyIndex]>a[j] &&  keyIndex<j){
                    int temp=a[keyIndex];
                    a[keyIndex]=a[j];
                    a[j]=temp;
                    keyIndex++;
                }
        }

        }
        return a;
    }
}
