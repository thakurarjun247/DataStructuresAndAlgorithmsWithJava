package codeonline.leetcode.intervals;
import java.util.*;
public class Intervals {

    public static void main(String[] args) {
        int[][] ivls={{1,5}};
        int[] newInt={2,3};
        int[][] ans=new Intervals().insert(ivls, newInt);
       // System.out.println(new Intervals().insert(ivls, newInt));
        util.ArrayUtil.printArray(ans);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        Queue<int[]> q= new LinkedList<>();
        boolean added=false;
        List<int[]> ans = new ArrayList<>();
        for(int[] a:intervals){
            q.add(a);
        }
        while(!q.isEmpty())
        {
            int[] item= q.poll();
            if(isOver(newInterval,item)){
                newInterval=merge(newInterval,item);
                added=true;
                if(q.size()==0)
                    ans.add(newInterval);
                continue;
            }
            else{
                if(newInterval[0]<item[0]){
                    ans.add(newInterval);
                    ans.add(item);
                    added=true;
                }
                else{
                    ans.add(item);

                }

            }
        }
        while(!q.isEmpty())
        {
            ans.add(q.poll());
        }
        if(!added)
            ans.add(newInterval);
        return ans.toArray(new int[ans.size()][2]);
    }
    public int[] merge(int[] a, int[] b){
        return new int[]{Math.min(a[0],b[0]), Math.max(a[1],b[1])};
    }
    public boolean isOver(int[] a, int[] b){
        return  Math.max(a[0],b[0])<=Math.min(a[1],b[1]);
    }
}


