package problemsfrombooks.clrs.array;

public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {0, 1,3,4};
       // int recursiveIndex = recursive(a, 0, a.length - 1, 3);
       // int iterativeIndex = iterative(a, 0, a.length - 1,3);

        int recursiveIndex = recursive(a, 0, a.length - 1, 2);
        int iterativeIndex = iterative(a, 0, a.length - 1,2);

        System.out.println(recursiveIndex + " " +iterativeIndex+ " " +(recursiveIndex == iterativeIndex));
    }

    static int recursive(int[] a, int l, int h, int key) {
        if (l > h)
            return -1;
        int m = (l + h) / 2;
        if (a[m] == key)
            return m;
        if (a[m] > key)
            return recursive(a, l, m - 1, key);
        else
            return recursive(a, m + 1, h, key);
    }

    static int iterative(int[] a, int l, int h, int key) {

        while (l <= h) {
            int m = (l + h) / 2;
            if (a[m] == key)
                return m;
            if (a[m] > key ) {
                h = m - 1;
            } else
                l = m + 1;

        }
        return -1;
    }

}
