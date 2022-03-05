package Algorithm_II.Day16.problem300;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length, maxValue = 1;
        int[] dp = new int[length + 1];
        dp[0] = 0; dp[1] = 1;

        for (int i = 2; i <= length; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (nums[i - 1] > nums[j - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxValue = Math.max(maxValue, dp[i]);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
//        System.out.println(solution.lengthOfLIS(new int[] {4,10,4,3,8,9}));
//        System.out.println(solution.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
        System.out.println(solution.lengthOfLIS(new int[] {1,3,6,7,9,4,10,5,6}));
    }
}
