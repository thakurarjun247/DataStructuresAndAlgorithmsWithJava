package mission_mahakal.clrs.chapter02;

public class _2_3_1MergeSort {
    public static void main(String[] arr){
        int[] a={2,4,5,800,900};
        mergeSort(a, 0, 4);
        util.GenericUtil.printArray(a);
    }

    static void mergeSort(int[] a, int p, int r){
        if(a==null || a.length==0 || p>=r)
            return;
        int q=(p+r)/2;
        mergeSort(a, p, q);
        mergeSort(a,q+1, r);
       merge(a,p,q,r);

    }
    static void merge(int[] a, int p, int q, int r){
        int[] auxillaryArray= new int[a.length];
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

           for(int i=0;i<a.length;i++)
               a[i]=auxillaryArray[i];


    }
}
