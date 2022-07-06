package Algorithm_III.Day16.problem714;

//f[i][0]：手上持有股票的最大收益
//f[i][1]：手上未持有股票的最大收益
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        if (prices.length == 1) {
            return 0;
        }

        int[][] f = new int[length][2];
        int f10 = -prices[0], f11 = 0, f00, f01;
        for (int i = 1; i < length; i++) {
            f00 = Math.max(f10, f11 - prices[i]); // fjk means f[i-j][k]
            f01 = Math.max(f11, f10 + prices[i] - fee);
            f10 = f00;
            f11 = f01;
        }
        return Math.max(f10, f11);
    }
}
