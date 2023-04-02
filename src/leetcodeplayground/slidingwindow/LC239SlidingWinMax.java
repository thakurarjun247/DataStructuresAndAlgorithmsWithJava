package leetcodeplayground.slidingwindow;
import java.util.*;
public class LC239SlidingWinMax  {
    public static void main(String[] args) {



        LC239SlidingWinMax object=new LC239SlidingWinMax();
        System.out.println((object.totalFruit(new int[]{0,1,2,2})));
        //==new int[]{3,3,5,5,6,7
    }

    public int totalFruit(int[] a) {
        return totalFruit(a, 2);
    }
        public int totalFruit(int[] a, int k) {

        Set<Integer> set= new HashSet<>();
        Map<Integer, Integer> map=new HashMap<>();
        int max=0;
        int right=0;


        for(int left=0;left<a.length && right<a.length;left++){
            //expand right
            while(map.size()<=k && right<a.length){
                //check if adding this item to the window will make the mapsize > k
                if(map.size()==k && right<a.length-1 && !map.containsKey(a[right+1]))
                {
                    max=Math.max(max, right-left);
                    break;
                }
                else

                {
                    map.put(a[right], right++);
                    max=Math.max(max, right-left+1);
                }
            }

            //shrink on left
            if(map.get(a[left])==left)
                map.remove(a[left]);

        }

        return max;
    }
}