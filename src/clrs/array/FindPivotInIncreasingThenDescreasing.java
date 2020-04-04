package clrs.array;

public class FindPivotInIncreasingThenDescreasing {
    public static void main(String[] args) {
        int[] a = {  1, -90};
        int index = f(a, 0, a.length - 1);
        System.out.println(index + " ");
    }

    public static int f(int[] a, int l, int h) {
        //0 element
        if (a.length == 0)
            return -1;
        if (l == h)
            return h;
        //return max if length 2
        if (l == (h - 1)) {
            if (a[l] > a[h])
                return l;
            else
                return h;
        }
        //three or more items
        int m = (h + l) / 2;
        int middle = a[m];
        int left = a[m - 1];
        int right = a[m + 1];


        //exactly on the mid element
        if (left < middle && middle > right)
            return m;
        //search left half
        if (left > middle && middle > right)
            return f(a, l, m - 1);
            //search right
        else
            return f(a, m + 1, h);


    }
}
