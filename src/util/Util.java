package util;

public class Util {
    public static <T> void  println(T t){
        System.out.println(t);
    }
    public static <T> void  print(T t){
        System.out.print(t);
    }
    public static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void printArray(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println("");
    }
    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+", ");
        }
        System.out.print("]");
        System.out.println("");
    }

    public  static <T> void printArray(T[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println("");
    }

    public static <T> T[] swapArrayElements(T[] a, int i, int j){
        T temp=a[i];
        a[i]=a[j];
        a[j]=temp;
        return a;
    }
}
