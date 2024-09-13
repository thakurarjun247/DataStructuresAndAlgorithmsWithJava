package algorithms.dp.bottomup2024;

//refer https://www.youtube.com/watch?v=s6FhG--P7z0&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=3
public class SubsetSum {
    public static void main(String[] args) {
        System.out.println(subsetSum(new int[]{2, 3, 7, 8, 10}, 10));
    }


    static boolean subsetSum(int[] nums, int sum) {
        int R = nums.length + 1;
        int C = sum + 1;
        boolean[][] m = new boolean[R][C];
        // Initialize first column to true (subset sum of 0 is always possible)
        for (int i = 0; i < R; i++) {
            m[i][0] = true;
        }
        for (int i = 1; i < R; i++)
            for (int j = 1; j < C; j++) {
                boolean previousRow = false;
                //beware index of nums
                //it's one less than that of the matrix m.
                //or simply add a zero at zeroth position of nums to make it consistent
                if (j  >= nums[i - 1])
                    previousRow = m[i - 1][j - nums[i - 1]];
                m[i][j] = (previousRow || m[i - 1][j] || nums[i - 1] == j);
            }
        return m[R - 1][C - 1];
    }
}
