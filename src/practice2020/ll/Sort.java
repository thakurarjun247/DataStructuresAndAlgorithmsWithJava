package practice2020.ll;

public class Sort {

    public int[] insertionSort(int[] a){
        if(a.length==0) return a; //needed?
        for(int i=0;i<a.length-1;i++)
            for(int j=i+1; j<a.length;j++){
                if(a[i]<a[j]){
                    int temp=a[i];
                    a[i]=a[j];
                    for(int k=i+1;k<a.length;k++){

                    }
                }
            }
        return a;
    }

}
