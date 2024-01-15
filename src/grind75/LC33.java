package grind75;

public class LC33 {

        public static int search(int[] nums, int target) {
            int low = 0, high = nums.length - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (nums[mid] == target) {
                    return mid;
                }

                // Determine which half is sorted and adjust search accordingly
                if (nums[mid] < nums[high]) {  // Right half is sorted
                    if (target > nums[mid] && target <= nums[high]) {
                        //search right
                        low = mid + 1;
                    } else {
                        //search left
                        high = mid - 1;
                    }
                } else {  // Left half is sorted
                    if (target >= nums[low] && target < nums[mid]) {
                        //search left
                        high = mid - 1;
                    } else {
                        //search right
                        low = mid + 1;
                    }
                }
            }

            return -1;  // Target not found
        }

        public static void main(String[] args) {
            int[] nums = {4, 5, 6, 7, 0, 1, 2};
            int target = 0;
            int index = search(nums, target);
            System.out.println("Index of target: " + index);
        }


}
