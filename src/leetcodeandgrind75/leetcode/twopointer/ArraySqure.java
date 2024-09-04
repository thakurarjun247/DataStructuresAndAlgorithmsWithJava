package leetcodeandgrind75.leetcode.twopointer;

import util.ArrayUtil;

public class ArraySqure {
    public static void main(String[] args) {
        ArrayUtil.printArray(new Solution().sortedSquares(new Integer[]{-5,-3,-2,-1}));
    }
}

class Solution {
    Integer[] ans;
    public Integer[] sortedSquares(Integer[] nums) {
        int n=nums.length;
        ans= new Integer[n];
        int left=0;
        int right=0;
        while(right<n && nums[right]<0)
            right++;
        left=right-1;
        if(left== -1){
            fill(nums, 0, n-1 );
            return ans;
        }
        if(right==n){
            for(int i=right-1;i>=0;i--)
                ans[n-1-i]=nums[i]*nums[i];
            return ans;
        }

        int index=0;
        while(left>=0 && right<n){
            boolean isLeftSmall=nums[left]*nums[left]<nums[right]*nums[right];
            ans[index++]= isLeftSmall?nums[left]*nums[left]:nums[right]*nums[right];
            if(isLeftSmall)
                left--;
            else
                right++;

        }
        if(right==n)
            fill(nums, 0, left);
        else
            fill(nums, right, n-1);

        return ans;
    }

    void fill(Integer[] a, int l, int r){
        for(int i=l;i<=r;i++)
            ans[i]=a[i]*a[i];
    }
}