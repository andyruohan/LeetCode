package Algorithm_I.Day12.problem70;

public class Solution {
    public static int climbStairs(int n) {
        int [] dp = new int[n + 1];
        dp[1] = 1;
        if (n <= 1) return dp[n];
        dp[2] = 2;
        if (n <= 2) return dp[n];

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
    }
}
