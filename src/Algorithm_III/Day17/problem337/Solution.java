package Algorithm_III.Day17.problem337;

public class Solution {
    public int rob(TreeNode root) {
        // 大致思路：层序遍历 + dp[层]
        // dp[层]：当前层可盗取的最高金额，dp[层] = Math.max(dp[层 - 1], dp[层 - 2] + 当前层总金额)
        return 0;
    }
}
