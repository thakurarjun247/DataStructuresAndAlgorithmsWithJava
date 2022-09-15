package mission_mahakal.clrs.chapter02;

public class _2_1InsertionSort {
    public static void main(String[] a){
        int[] b={3,4,2,6,1};
        insertionSort(b);
        util.GenericUtil.printArray(b);
    }
    static void insertionSort(int[] a){
        if(a==null || a.length==0)
            return;
        for(int j=1;j<a.length;j++){
            int key=a[j];
            int i=j-1;
            while(i>=0 && a[i]>key){
                a[i+1]=a[i];
                i--;
            }
            a[i+1]=key;
        }
    }
}
