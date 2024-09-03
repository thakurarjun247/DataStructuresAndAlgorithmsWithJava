package datastructuresandalgorithms.problemsfrombooks.clrs.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// Given a set of activities, each with a start time and a finish time,
// the goal is to select a maximum number of non-overlapping activities.
// In other words, no two selected activities can have overlapping time intervals.
public class ActivitySelectionGreedy {
    public static void main(String[] args) {

        int[][] activities = {
                {1, 2},  // Activity 1: start=1, finish=2
                {5, 9},   // Activity 2: start=5, finish=9
                {3, 4},  // Activity 3: start=3, finish=4
                {5, 7},  // Activity 4: start=5, finish=7
                {0, 6},  // Activity 5: start=0, finish=6
                {8, 9},  // Activity 6: start=8, finish=9
        };
        selectActivities(activities)
                .forEach(item -> System.out.println(Arrays.toString(item)));
    }

    //The goal in the Activity Selection Problem is to select the maximum
    // number of non-overlapping activities from a given set of activities.
    static  List<int[]> selectActivities(int[][] activities){
        //sort in order of finish time.
        Arrays.sort(activities, (x,y)->x[1]-y[1]);
        List<int[]> list= new ArrayList<>();
        list.add(activities[0]);
        for(int i=1;i<activities.length;i++){
            //if start of this activity after finish of last activity
            if(activities[i][0] >= list.get(list.size() - 1)[1]){
                list.add(activities[i]);
            }
        }

        return list;
    }


}



