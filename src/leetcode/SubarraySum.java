package leetcode;

import java.util.*;

public class SubarraySum {
    public static void main(String[] args) {
        int[] a={2,3,2,3,2,3};
        System.out.println(f(a, 5));
        f1("012345678", "");
    }

    static int f1(String n1, String n2){
        for(int i=0;i<n1.length();i++) {
            int num = n1.charAt(i) - '0';
            System.out.println(num);
        }
        return 0;
    }
    static int f(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int sum = 0;
        map.put(0, 1);
        for (int i = 0; i < a.length; i++) {

            sum += a[i];
            if (map.containsKey(sum - k))
                //this?
                result += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}
