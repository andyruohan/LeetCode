package Algorithm_II.Day18.problem322;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = amount + 1;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, amount);
        dp[0] = 0; dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j: coins) {
                if (i - j >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - j] + 1);
                }
            }
        }
        return dp[amount] < amount ? dp[amount] : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
//        System.out.println(solution.coinChange(new int[]{1}, 0));
        System.out.println(solution.coinChange(new int[]{186, 419, 83, 408}, 6249));
    }
}
