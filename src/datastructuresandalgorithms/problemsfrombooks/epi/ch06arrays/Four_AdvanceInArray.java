package datastructuresandalgorithms.problemsfrombooks.epi.ch06arrays;

public class Four_AdvanceInArray {
    public static void main(String[] args) {
        int[] a={3,5,0,0,0,0,1};
        System.out.println(f(a));
    }
    static boolean f(int[] a){
        if (a.length < 2)
            return true;
        else return fRecursive(a, 0);
    }
    static boolean fRecursive(int[] a, int i) {

        if (i == a.length - 1)
            return true;
        boolean reachable=false;
        for(int j=1; j<=a[i];j++){
            reachable= reachable || fRecursive(a, i+j);
        }
        return reachable;

    }

    static boolean fIterative(int[] a){
        int target=a.length-1;
        int i=0;
        while(i!=target){
            int j=a[i];
        }
        //TODO: remove dummy return
        return false;
    }
}
