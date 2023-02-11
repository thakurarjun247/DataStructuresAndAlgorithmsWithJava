package leetcodeplayground.slidingwindow;
import java.util.*;
public class LC904 {
    public static void main(String[] args) {

        System.out.println(new Solution().totalFruit1(new int[]{1,2,3,2,0,2}));
    }
}
class Solution {
    public int totalFruit1(int[] a) {
        int n=a.length;
        if(a==null || a.length==0)
            return 0;
        if(a.length<=2)
            return a.length;
        int ans=0;
        Map<Integer, Integer> lastIndexOf= new HashMap<>();


        // Hash map 'basket' to store the types of a.
        Set<Integer> set= new HashSet<>();

        int i = 0, j=0;
        set.add(a[j]);

        // Add fruit from j side (j) of the window.
        for (j = 0; j < a.length; j++) {

            while(set.size()<2 && j<n ){
                set.add(a[j]);
                j++;
                lastIndexOf.put(a[j], j);
            }
            int count=j-i;
            ans= Math.max(count, ans);
            List<Integer> list= new ArrayList<>(set);

            int oldItem;
            if(lastIndexOf.get(list.get(0))<lastIndexOf.get(list.get(1)))
                oldItem=list.get(0);
            else
                oldItem=list.get(1);




            set.remove(oldItem);
            i=lastIndexOf.get(oldItem);
        }
        return ans;

    }
    public int totalFruit(int[] fruits) {
        // Hash map 'basket' to store the types of fruits.
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right;

        // Add fruit from right side (right) of the window.
        for (right = 0; right < fruits.length; ++right) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            // If the current window has more than 2 types of fruit,
            // we remove one fruit from the left index (left) of the window.
            if (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0)
                    map.remove(fruits[left]);
                left++;
            }
        }

        // Once we finish the iteration, the indexes left and right
        // stands for the longest valid subarray we encountered.
        return right - left;
    }
}