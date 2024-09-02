package datastructuresandalgorithms.problemsfrombooks.clrs.greedy;

import java.util.*;

public class Greedy {


    public static void main(String sw[]) {
  /*      PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.add(10);
        pq.add(0);
        pq.add(20);
        pq.add(40);
        pq.add(30);
        pq.forEach(System.out::print);*/

        //start and finish times
        int[] s1 = {1, 3, 0, 5, 8, 5};
        int[] f1 = {2, 4, 6, 7, 9, 9};

        int[] s2 = {1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
        int[] f2 = {4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};

                ActivitySelection a = new ActivitySelection();
       // a.activitySelectionGreedy(s1,f1);
        a.activitySelectionGreedy(s2,f2);

    }


}

class Activity implements Comparable {
    int s;
    int f;

    public Activity() {
    }

    public Activity(int s, int f) {
        this.s = s;
        this.f = f;
    }

    @Override
    public int compareTo(Object o) {
        Activity a = (Activity) o;
        return this.f-a.f;
    }

    @Override
    public String toString() {
        return s + "->" + f + " ";
    }

}

class ActivitySelection {
    public void activitySelectionGreedy(int[] s, int[] f) {
        List<Activity> activities = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            Activity act= new Activity(s[i], f[i]);
            activities.add(act);

        }
        Collections.sort(activities);
        //List<Activity> rec = rec(activities);
        //rec.forEach(System.out::println);
        List<Activity> itr = itr(activities);
        itr.forEach(System.out::println);

        // List<Activity> itr = asItr(activities);
    }

    List<Activity> rec(List<Activity> list) {
        if (list == null || list.isEmpty())
            return new ArrayList<Activity>();
        List<Activity> ans = new ArrayList<Activity>();
        ans.add(list.get(0));
        return rec(list, ans, list.get(0), 1);
    }

    List<Activity> rec(List<Activity> list, List<Activity> ans, Activity lastAct, int currentIndex) {
        if (list.isEmpty()) return ans;
        for (int i = currentIndex; i < list.size(); i++) {
            Activity item = list.get(i);
            if (item.s >= lastAct.f) {
                ans.add(item);
                return rec(list, ans, item, i + 1);
            }
        }
        return ans;

    }

    List<Activity> itr(List<Activity> list) {
        List<Activity> ans = new ArrayList<>();
        if(list==null || list.isEmpty()) return ans;
        Activity lastAct=list.get(0);
        ans.add(lastAct);
        for(int i=1;i<list.size();i++){
            Activity currentAct=list.get(i);
            if(currentAct.s>=lastAct.f){
                ans.add(currentAct);
                lastAct=currentAct;
            }
        }

        return ans;
    }
}

