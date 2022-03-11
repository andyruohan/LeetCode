package Algorithm_II.Day18.problem343;

public class Solution {
    public int integerBreak(int n) {
        int maxValue = 0;
        int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.integerBreak(10));
    }
}
