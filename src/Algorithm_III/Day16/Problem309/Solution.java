package Algorithm_III.Day16.Problem309;

// f[i][0]: 手上持有股票的最大收益
// f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
// f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
public class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 1) {
            return 0;
        }

        int[][] f = new int[length][3];
        f[0][0] = -prices[0];
        for (int i = 1; i < length; ++i) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        return Math.max(f[length - 1][1], f[length - 1][2]);
    }
}
