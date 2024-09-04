package leetcodeandgrind75.leetcode.arrays;

public class DupNum {
}


class SolutionDupNum {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{4, 3, 1, 1, 2}));
    }


    public static int findDuplicate(int[] nums) {
        while (nums[0] != nums[nums[0]]) {
            int next = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = next;
        }
        return nums[0];
    }
}