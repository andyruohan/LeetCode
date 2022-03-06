package Algorithm_II.Day16.problem673;

public class Solution {
    public int findNumberOfLIS(int[] nums) {
        int length = nums.length, maxLength = 1, numberOfLIS = 1;
        int[] dp = new int[length + 1];
        int[] cnt = new int[length + 1];
        dp[0] = 0; dp[1] = 1;
        cnt[0] = 0; cnt[1] = 1;

        for (int i = 2; i <= length; i++) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 1; j < i; j++) {
                if (nums[i - 1] > nums[j - 1]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                numberOfLIS = cnt[i];
            } else if (dp[i] == maxLength) {
                numberOfLIS += cnt[i];
            }
        }

        return numberOfLIS;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.findNumberOfLIS(new int[] {2, 2, 2, 2, 2}));
        System.out.println(solution.findNumberOfLIS(new int[] {1,3,5,4,7}));
    }
}
