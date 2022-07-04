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
        int f10 = -prices[0], f11 = 0, f12 = 0, f00, f01, f02;
        for (int i = 1; i < length; ++i) {
            f00 = Math.max(f10, f12 - prices[i]); //fjk means f[i - j][k]
            f01 = f10 + prices[i];
            f02 = Math.max(f11, f12);
            f10 = f00;
            f11 = f01;
            f12 = f02;
        }
        return Math.max(f11, f12);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{1, 4, 2}));
    }
}
