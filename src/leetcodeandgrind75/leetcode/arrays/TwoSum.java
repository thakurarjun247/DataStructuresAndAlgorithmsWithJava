package leetcodeandgrind75.leetcode.arrays;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {


        int[] nums = {2, 7, 11, 15};
        int target = 9;

        Map<Integer, Integer> map = new HashMap<>();

        // Iterate through the datastructures.array and store the complement of each number in a HashMap
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                int[] indices = {map.get(complement), i};
                System.out.println("Indices of the two numbers that add up to " + target + " are " + Arrays.toString(indices));
                return;
            }
            map.put(nums[i], i);
        }

        // If no two numbers add up to the target, print an error message
        System.out.println("No two numbers add up to " + target);
    }
}
