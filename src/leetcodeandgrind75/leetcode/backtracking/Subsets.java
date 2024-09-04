package leetcodeandgrind75.leetcode.backtracking;
import  java.util.*;
public class Subsets {
    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{2,1,3}));
    }

    //https://leetcode.com/problems/subsets/
    //Given an integer datastructures.array nums of unique elements, return all possible
    //subsets
    // (the power set).
    //
    //The solution set must not contain duplicate subsets. Return the solution in any order.
    //Example 1:
    //
    //Input: nums = [1,2,3]
    //Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
       //Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
