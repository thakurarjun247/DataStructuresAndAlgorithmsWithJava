package algorithms.ch16recursion;

import java.util.*;

public class PowerSet {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Integer> tail = new ArrayList<>();
        tail.addAll(list);
        int head = tail.remove(0);


        Set<Set<Integer>> sets=powerSet(Arrays.asList(1, 2, 3));
        sets.forEach(set ->
                System.out.println(set));
    }

    static Set<Set<Integer>> powerSet(List<Integer> nums) {

        Set<Set<Integer>> sets = new HashSet<Set<Integer>>();
        sets.add(new HashSet<Integer>());
        return powerSet(nums, sets);
    }

    static Set<Set<Integer>> powerSet(List<Integer> nums, Set<Set<Integer>> sets) {
        if (nums.size() == 0)
            return sets;
        if (nums.size() == 1) {
            Set<Integer> set = new HashSet<Integer>();
            set.add(nums.get(0));
            sets.add(set);
            return sets;
        } else {
            List<Integer> tail = new ArrayList<>();
            tail.addAll(nums);
            int head = tail.remove(0);
            Set<Set<Integer>> tailSet = powerSet(tail);
            //sets.addAll(tailSet);
            tailSet
                    .forEach(set -> {
                        set.add(head);
                        sets.add(set);
                    });


        }
        return sets;
    }
}
