package leetcodeandgrind75.leetcode.arrays;

public class SortedRotatedArray {
    public static void main(String[] args) {
        SolutionTest test = new SolutionTest();
/*        test.exampleTestCases();
        test.edgeCases();
        test.rotatedArrayTestCases();*/

    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            //todo: unlearn this:
            // forget about inflexion point altogether ()

            //7,8,9,0,1,2,3,4,5
            //left is sorted
            if (nums[left] <= nums[mid]) {
                //number lies in the left
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                }
                //number lies in the right
                else {
                    left = mid + 1;
                }

            }
            //if left not sorted, right is sorted for sure
            else {
                //if target in the right
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    //target in the left
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}

class SolutionTest {

    SortedRotatedArray solution = new SortedRotatedArray();

/*    @Test
    void exampleTestCases() {
        assertEquals(4, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        assertEquals(-1, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    @Test
    void rotatedArrayTestCases() {
        assertEquals(2, solution.search(new int[]{6, 7, 1, 2, 3, 4, 5}, 1));
        assertEquals(0, solution.search(new int[]{5, 1, 2, 3, 4}, 5));
        assertEquals(4, solution.search(new int[]{5, 6, 7, 8, 1, 2, 3, 4}, 1));
        assertEquals(2, solution.search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 6));
        assertEquals(7, solution.search(new int[]{3, 4, 5, 6, 7, 8, 1, 2}, 2));
        assertEquals(3, solution.search(new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3}, 8));
    }

    @Test
    void edgeCases() {
        assertEquals(-1, solution.search(new int[]{}, 0));
        assertEquals(0, solution.search(new int[]{1}, 1));
        assertEquals(-1, solution.search(new int[]{1}, 0));
    }*/
}

