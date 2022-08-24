package algorithms.sorting;

//https://www.youtube.com/watch?v=gbJzL6IJig0
//scan from left to right
//for each item
//insert it to the right place, by scanning the array left to right

public class InsertionSort {
    public static void main(String[] args) {
        int a[]={5,4,10,3,0,1,4,4,9};
       util.GenericUtil.printArray(insertionSort(a));
    }
    public static int[] insertionSort(int[] a){
        for(int i=1;i<a.length;i++){
            //This will keep moving to left
            int keyIndex=i;
            for(int j=i-1;j>=0 && keyIndex>=0;j--){


                if( a[keyIndex]<a[j]  ){
                    int temp=a[keyIndex];
                    a[keyIndex]=a[j];
                    a[j]=temp;
                    //move left
                    keyIndex--;
                }
            }
        }
        return a;
    }
}
