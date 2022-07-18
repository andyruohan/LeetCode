package Algorithm_III.Day18.problem85;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int res = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '0') continue;
                dp[i][j] = dp[i][j - 1] + 1;
                int maxArea = dp[i][j], minLength = dp[i][j];
                for (int height = 2; i >= height && matrix[i - height][j - 1] != '0'; height++) {
                    minLength = Math.min(minLength, dp[i - height + 1][j]);
                    maxArea = Math.max(maxArea, height * minLength);
                }
                res = Math.max(res, maxArea);
            }
        }
        return res;
    }
}

