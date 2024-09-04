package algorithms.sorting.chapter02;

import util.ArrayUtil;

public class _2_3_1MergeSort {
    public static void main(String[] arr){
        Integer[] a={62344,24,63,-4,-2352};
        Integer[] auxillaryArray= new Integer[a.length];
        mergeSort(a, auxillaryArray, 0, a.length-1);
        ArrayUtil.printArray(auxillaryArray);

    }

    static void mergeSort(Integer[] a,Integer[] auxillaryArray, int p, int r){
        if(a==null || a.length==0 || p>=r)
            return;
        int q=(p+r)/2;
        mergeSort(a,auxillaryArray, p, q);
        mergeSort(a,auxillaryArray,q+1, r);

        merge(a,auxillaryArray, 0, q,a.length-1);


    }
    static void merge(Integer[] a,Integer[] auxillaryArray, int p, int q, int r){

        int currentWriter=0;
        int left=p;
        int right =q+1;
        while(left<=q && right<=r && currentWriter<auxillaryArray.length){
            if(a[left]<a[right])
            {
                auxillaryArray[currentWriter]=a[left];
                left++;
            }
            else{
                auxillaryArray[currentWriter]=a[right];
                right++;
            }
            currentWriter++;
        }
        //reached the end of one of the arrays , now copying the elements

            while(left<=q){

                auxillaryArray[currentWriter]=a[left];
                left++;
                currentWriter++;


        }

           while(right<=r) {

               auxillaryArray[currentWriter] = a[right];
               right++;
               currentWriter++;
           }




    }
}
