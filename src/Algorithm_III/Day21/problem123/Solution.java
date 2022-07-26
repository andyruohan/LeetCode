package Algorithm_III.Day21.problem123;

public class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (prices.length == 1) {
            return 0;
        }

        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;
        for (int i = 0; i < length; i++) {
            firstBuy = Math.max(firstBuy, -prices[i]);
            firstSell = Math.max(firstSell, prices[i] + firstBuy);
            secondBuy = Math.max(secondBuy, firstSell - prices[i]);
            secondSell = Math.max(secondSell, prices[i] + secondBuy);
        }

        return secondSell;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }
}
