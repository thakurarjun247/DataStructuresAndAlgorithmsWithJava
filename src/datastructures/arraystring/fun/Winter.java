package datastructures.arraystring.fun;

import java.util.ArrayList;
import java.util.List;

public class Winter {

    public static void main(String[] args) {
        int a[] = {2, 3, 0, 5, 6, 4, 10, 11, 12};
        System.out.println(getSummerIterative(a));

    }

    public static int getSummerIterative(int[] a) {
        List<Integer> list = new ArrayList<>();
        int max = a[0];
        int prev = a[0];
        int summer = 1;
        list.add(summer);
        for (int i = 0; i < a.length; i++) {
            if (i == 8) {
                System.out.println();
            }
            if (a[i] > max && a[i] > prev) {
                list.add(i);

            } else {
                if (!list.isEmpty()) {
                    //list.remove(list.size() - 1);
                    list.clear();
                }

            }
            prev = a[i];
            max = Math.max(max, a[i]);
        }
        return list.get(0);

    }

}
