package Algorithm_III.Day20.problem416;

import java.util.*;

public class Solution {
    boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (preCheck(nums, sum)) {
            int m = nums.length, n = sum / 2;
            dp = new boolean[m][n + 1];
            for (int i = 0; i < m; i++) {
                dp[i][0] = true;
            }
            dp[0][nums[0]] = true;
            for (int i = 1; i < m; i++) {
                int num = nums[i];
                for (int j = 1; j <= n; j++) {
                    if (j >= num) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[m - 1][n];
        } else {
            return false;
        }
    }

    public boolean preCheck(int[] nums, int sum) {
        if (sum % 2 == 1) {
            return false;
        } else return nums[0] <= sum / 2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.canPartition(new int[]{2, 2, 1, 1}));
//        System.out.println(solution.canPartition(new int[]{9,1,2,4,10}));
//        System.out.println(solution.canPartition(new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97}));
//        System.out.println(solution.canPartition(new int[]{1, 5, 11, 5}));
//        System.out.println(solution.canPartition(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,100}));
//        System.out.println(solution.canPartition(new int[]{18,17,18,11,15,4,13,11,9}));
        System.out.println(solution.canPartition(new int[]{9, 5}));
//        System.out.println(solution.canPartition(new int[]{14,9,8,4,3,2}));
    }
}
