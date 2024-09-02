package grindlc.leetcode.slidingwindow;
import java.util.*;
public class LC904 {
    public static void main(String[] args) {

        System.out.println(new Solution().totalFruit(new int[]{1,2,3,2,2}));
    }
}
class Solution {
    private boolean add(Integer item){
        if(!set.contains(item) && set.size()==2)
            return false;
        else{
            set.add(item);
            return true;
        }
        /*
          if(set.contains(item))
            return true;
        else {
            if(set.size()<2)
            {
                set.add(item);
                return true;
            }
            return false;
        }
         */


    }
    Set<Integer> set= new HashSet<>();
    public int totalFruit(int[] a) {
        int n=a.length;
        if(n<=2)
            return n;
        int ans=0;
        int right=0;
        int windowSize =1;
        set.add(a[0]);
        for(int left=0;left<n;left++){
            if(set.size()>=2)
            {
                windowSize--;
                continue;
            }

            //set.clear();
            while(right<n-1 && add(a[right]) ){

                windowSize++;
                right++;
            }
            ans= Math.max(windowSize, ans);
        }
        return ans;
    }
}